package com.example.testlib.uitest.mock_entity

object ObjectClass {
    var name: String = "我是用于ObjectClass的name"

    private var gender: Int = 0

    fun getObjectFunction(): String {
        return getPrivateFunction()
    }

    fun getPublicGender():Int{
        return gender
    }

    private fun getPrivateFunction(): String {
        return "我是私有的方法，你能不能调用到我呀"
    }
}