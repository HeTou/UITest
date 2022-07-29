package com.example.testlib.testEntity.constructor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.example.testlib.R

abstract class InternalConstructor2(context: Context) : FrameLayout(context) {

    lateinit var view: TextView

    init {
        initView()
    }

     fun initView(): View {
        val inflate = LayoutInflater.from(context)
        inflate.inflate(R.layout.activity_main, this, true)
        view = findViewById<TextView>(R.id.tv)
        return view
    }
}