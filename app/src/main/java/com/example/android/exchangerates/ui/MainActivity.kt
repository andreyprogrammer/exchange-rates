package com.example.android.exchangerates.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android.exchangerates.R
import com.example.android.exchangerates.databinding.ActivityMainBinding
import com.example.android.exchangerates.model.ExchangeDatabase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var sharedPreferences: SharedPreferences
    private val key = "KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        val application = requireNotNull(this).application
        val dataSource = ExchangeDatabase.getInstance(application).exchangeDatabaseDao
        val viewModelFactory = MainViewModelFactory(dataSource, application)
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel
        binding.container.exchangeList.adapter = ExchangeAdapter(ExchangeAdapter.OnClickListener {
            mainViewModel.changeCurrency(it)
        })

        binding.container.input.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s != "" && s != "0" && count > 0) {
                    mainViewModel.setCurrentRub(s.toString())
                }
            }

            override fun afterTextChanged(editable: Editable) {
                if (editable.toString() != "" && editable.toString() != "0") {
                    mainViewModel.setCurrentRub(editable.toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //
            }
        })

//        if ()

        update()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                update(); true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun update() {
        mainViewModel.exchangeRequest()
        binding.invalidateAll()
    }

    fun isFirstStart(): Boolean {
        sharedPreferences = getPreferences(MODE_PRIVATE)
        return sharedPreferences.getString(key, "isFirstStart") == "isFirstStart"
    }

    fun savePreferences() {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, "isSecondStart")
        editor.apply()
    }

}