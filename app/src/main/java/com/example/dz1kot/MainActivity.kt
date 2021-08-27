package com.example.dz1kot

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var resultLauncher: ActivityResultLauncher<Intent>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForActivity()
        setUpListener()
    }

    private fun setUpListener() {
        btn.setOnClickListener {
            if (edit.text.toString() == "") {
                Toast.makeText(this, getString(R.string.warning1), Toast.LENGTH_SHORT)
            } else {
                openActivity()
            }
        }

    }

    private fun openActivity() {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("key", edit.text.toString())
        }
        resultLauncher.launch(intent)
    }
    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    edit.setText(
                        result.data?.getStringExtra(
                            "key"
                        )
                    )


                }
            }
    }  }