package com.twodev.kotlinlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendAction()

        see_list.setOnClickListener {


            if (see_list.text == "Press me to see list") {
                for (i in list) {
                    var counter=""
                    counter+=i
                    et_m_activity.setText("${et_m_activity.text} |--> $counter")
                    Log.d("tag1", "onCreate: i = $i ")
                    Log.e("tag1", "onCreate: list Size ${list.size}")
                    see_list.text = "clear"
                }

            }else{
                et_m_activity.setText("")
                list.removeAll(list)
                Log.e("tag1", "onCreate: list Size $list")
                see_list.text = "Press me to see list"

            }
        }
    }

    private fun sendAction() {
        btn_press_me_m_activity.setOnClickListener {
            val intent = Intent(this, GenerateActivity::class.java)

            val textData = et_m_activity.text.toString();
            if (textData.isNotEmpty()) {
                list.add(textData)
                intent.putExtra("text", textData)
                startActivityForResult(intent, 0)
            } else {
                showToast("Enter data")
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val addData = data?.getStringExtra("result")
            addData?.let {
                et_m_activity.setText(addData)
                list.add(it) }
            Log.d("tag1","onActivityResult: $list")
        }

    }

}



