package com.example.testlib.mock_entity

import com.example.testlib.mock_entity.getStaticFunction
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/***
 * mock顶层方法、属性
 */
class TopLevelFunctionUnitTest {
    @Before
    fun setup() {
    }

    @Test
    fun test() {
        mockkStatic("com.example.testlib.TopLevelFunctionKt")
        every { getStaticFunction() } returns "hhah "

        println(getStaticFunction())
        Assert.assertEquals("hhah ", getStaticFunction())
    }
}