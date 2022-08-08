package com.shrouk.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager

import androidx.databinding.DataBindingUtil
import com.shrouk.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
     private val myName:MyName=MyName("ShroukSobhy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName
      // findViewById<Button>(R.id.done_button).setOnClickListener{
        //   addNickName(it)
       //}
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
          // nicknameText.text=binding.nicknameEdite.text
           myName?.nickname= binding.nicknameEdite.text.toString()
            invalidateAll()
            nicknameEdite.visibility=View.GONE
            nicknameText.visibility=View.VISIBLE
            doneButton.visibility=View.GONE

        }
        // Hide The Keyboard
        val imm= getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

    }
}