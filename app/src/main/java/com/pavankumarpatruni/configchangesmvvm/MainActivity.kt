package com.pavankumarpatruni.configchangesmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pavankumarpatruni.configchangesmvvm.viewmodel.CounterViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var counterViewModel: CounterViewModel
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)
        counterViewModel.getCounter().observe(this, Observer {
            counter = it
            setText()
        })

        buttonCounter.setOnClickListener {
            ++counter
            setText()
        }

        setText()
    }

    private fun setText() {
        textViewCount.text = counter.toString()
    }

    override fun onStop() {
        super.onStop()

        counterViewModel.saveCounter(counter)
    }
}
