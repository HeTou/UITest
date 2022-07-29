package com.example.testlib.testEntity.constructor

import android.content.Context

class TestConstructor {
    var name: String? = null
    var age: Int? = null

    constructor() {}

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String?, age: Int?) {
        this.name = name
        this.age = age
    }


    fun getNameStr(): String {
        return name + "Version"
    }


    fun runInternal(context: Context) {
        val internalConstructor = InternalConstructor(context)
        val nameStr = internalConstructor.initView()
    }
}