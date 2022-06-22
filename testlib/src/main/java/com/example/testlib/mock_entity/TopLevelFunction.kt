package com.example.testlib.mock_entity

fun getStaticFunction(): String {
    return getStaticFunction2()
}


fun getStaticFunction2(): String {
    return "你是杀币"
}
