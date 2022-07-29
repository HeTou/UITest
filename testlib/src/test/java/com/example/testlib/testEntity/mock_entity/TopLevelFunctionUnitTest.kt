package com.example.testlib.testEntity.mock_entity

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
        mockkStatic("com.example.testlib.uitest.mock_entity.TopLevelFunctionKt")
        every { getStaticFunction() } returns "hhah "

        println(getStaticFunction())
        Assert.assertEquals("hhah ", getStaticFunction())
    }
}