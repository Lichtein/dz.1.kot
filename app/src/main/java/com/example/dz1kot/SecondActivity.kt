package com.example.dz1kot

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        checkIntent()
        setUpListener()
    }

    private fun setUpListener() {
        btn2.setOnClickListener {
            if (edit2.text.toString() == ""){
                Toast.makeText(this, (R.string.warning1), Toast.LENGTH_LONG)
            }else{
            openActivity()
            }
        }
    }

    private fun openActivity() {

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("key", edit2.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }


    private fun checkIntent() {
        edit2.setText(intent.getStringExtra("key"))
    }
}