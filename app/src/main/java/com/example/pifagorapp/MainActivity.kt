package com.example.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClickResult(view:View){
        if(!isFieldEmpty()){
            val result = getString(R.string.resultInfo) + getResult()
            binding.tvResult.text = result
        }

    }
    private fun isFieldEmpty(): Boolean {
        //проверка что значения не пустые
        binding.apply { // это чтобы можно было напрямую обращаться к элементам из разметки
            if(edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if(edB.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }
    private fun getResult(): String {
        // вычисление гипотенузы
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt( (a.pow(2) +b.pow(2)) ).toString()
    }



}