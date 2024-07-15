package com.example.tipscalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClean.setOnClickListener {
            println("andre" + binding.tieTotal.text)
            println("andre" + binding.tieNumPeople.text)
        }

        var percentage: Int = 0
        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                percentage = 20
            }
        }

        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumPeople.text

            if(totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true
                ) {
                Snackbar
                    .make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()

            } else {
                val totalTable = totalTableTemp.toString().toFloat()
                val nPeople = nPeopleTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                binding.tvResult.text = ("Total a pagar: $totalWithTips")
            }
        }
    }
}