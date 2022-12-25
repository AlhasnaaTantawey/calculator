package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var   viewModel:MyViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

      viewModel= ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.outputLiveData.observe(this){
            binding.textViewInputText.text=it
        }

        viewModel.lastResult.observe(this){
            binding.textViewOutputresult.text=it.result
        }

    }

    fun onclickListener_ImageButton(view: View) {

        var intent = Intent(this,MainActivityHistory::class.java)
        startActivity(intent)
    }

    fun Button2Action(view: View) {
        viewModel.number2OnClick()
    }
    fun ButtonClearAction(view: View) {
        viewModel.clearOnClick()
    }
    fun bnplusMinusButtonAction(view: View) {
        viewModel.plusMinusOnClick()
    }
    fun btDivisionOpEvent(view: View) {
        viewModel.divisionOnClick()
    }
    fun Button7Action(view: View) {
        viewModel.number7OnClick()
    }
    fun Button8Action(view: View) {
        viewModel.number8OnClick()
    }
    fun Button9Action(view: View) {
        viewModel.number9OnClick()
    }
    fun btMultiplicationOpEvent(view: View) {
        viewModel.multyOnClick()
    }
    fun Button4Action(view: View) {
        viewModel.number4OnClick()
    }
    fun Button5Action(view: View) {
        viewModel.number5OnClick()
    }
    fun Button6Action(view: View) {
        viewModel.number6OnClick()
    }
    fun btSubtractionOpEvent(view: View) {
        viewModel.subOnClick()
    }
    fun Button1Action(view: View) {
        viewModel.number1OnClick()
    }
    fun Button3Action(view: View) {
        viewModel.number3OnClick()
    }
    fun btPlusOpEvent(view: View) {
        viewModel.plusOnClick()
    }
    fun Button0Action(view: View) {
        viewModel.number0OnClick()
    }
    fun ButtonDotAction(view: View) {
        viewModel.numberDotOnClick()
    }
    fun equalButtonAction(view: View) {
        viewModel.equalOnclick()
    }

}