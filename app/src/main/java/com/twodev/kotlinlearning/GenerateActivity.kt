package com.twodev.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_generate.*

class GenerateActivity : AppCompatActivity() {
    private var data: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate)
        getIntentData()
        returnDataAction()
    }

    private fun returnDataAction() {
        btn_press_me_generate.setOnClickListener {
            val newData = et_generate.text.toString()
            if (newData == data) showToast("change data ")
            else returnData(newData)
        }
    }

    private fun returnData(data: String) {
        val intent = Intent()
        intent.putExtra("result", data)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun getIntentData() {
        data = intent.getStringExtra("text");
        et_generate.setText(data)

    }
}