package com.example.calculator2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.mariuszgromada.math.mxparser.*
import com.example.calculator2.databinding.ActivityMainBinding
import androidx.core.content.ContextCompat
import java.text.DecimalFormat



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClearAll.setOnClickListener {
            binding.tvInput.text = ""
            binding.tvResult.text = ""
        }

        binding.btnCross.setOnClickListener {
            val removedLast = binding.tvInput.text.toString().dropLast(1)
            binding.tvInput.text = removedLast
        }

        binding.btn0.setOnClickListener {
            binding.tvInput.text = addToInputText("0")
        }
        binding.btn1.setOnClickListener {
            binding.tvInput.text = addToInputText("1")
        }
        binding.btn2.setOnClickListener {
            binding.tvInput.text = addToInputText("2")
        }
        binding.btn3.setOnClickListener {
            binding.tvInput.text = addToInputText("3")
        }
        binding.btn4.setOnClickListener {
            binding.tvInput.text = addToInputText("4")
        }
        binding.btn5.setOnClickListener {
            binding.tvInput.text = addToInputText("5")
        }
        binding.btn6.setOnClickListener {
            binding.tvInput.text = addToInputText("6")
        }
        binding.btn7.setOnClickListener {
            binding.tvInput.text = addToInputText("7")
        }
        binding.btn8.setOnClickListener {
            binding.tvInput.text = addToInputText("8")
        }
        binding.btn9.setOnClickListener {
            binding.tvInput.text = addToInputText("9")
        }
        binding.btnPlus.setOnClickListener {
            binding.tvInput.text = addToInputText("+")
        }
        binding.btnMinus.setOnClickListener {
            binding.tvInput.text = addToInputText("-")
        }
        binding.btnMul.setOnClickListener {
            binding.tvInput.text = addToInputText("*")
        }
        binding.btnDivide.setOnClickListener {
            binding.tvInput.text = addToInputText("/")
        }
        binding.btnDot.setOnClickListener {
            binding.tvInput.text = addToInputText(".")
        }
        binding.btnResult.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return binding.tvInput.text.toString() + "" + buttonValue
    }

    private fun getInputExpression(): String {
        var expression = binding.tvInput.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.tvResult.text = ""
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                binding.tvResult.text = DecimalFormat("0.######").format(result).toString()
                binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.tvResult.text = ""
            binding.tvResult.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }


}