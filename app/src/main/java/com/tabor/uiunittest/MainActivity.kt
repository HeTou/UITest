package com.tabor.uiunittest

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testlib.pesenter.MainPesenter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClick(view: View) {
        Log.d("TAG","onClick")
        Toast.makeText(this,"111111",Toast.LENGTH_LONG).show()
        MainPesenter().add(1,1)
    }
}