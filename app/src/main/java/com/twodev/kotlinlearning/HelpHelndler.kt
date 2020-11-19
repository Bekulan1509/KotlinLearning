package com.twodev.kotlinlearning

import android.content.Context
import android.widget.Toast

public fun Context.showToast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}