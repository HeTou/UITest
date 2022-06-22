package com.example.testlib.mock_entity

import android.net.Uri
import com.example.testlib.mock_entity.ObjectClass
import io.mockk.every
import io.mockk.mockkObject
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/***
 * mock object类
 */
class ObjectClassUnitTest {
    @Before
    fun setup() {
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    /***
     * mock object类
     */
    @Test
    fun test_getObjectFunction() {
        mockkObject(ObjectClass)
        every { ObjectClass.getObjectFunction() } returns "我修改你的值"
        Assert.assertEquals("我修改你的值", ObjectClass.getObjectFunction())
    }

    /***
     * mock变量
     */
    @Test
    fun test_name() {
        mockkObject(ObjectClass)
        every { ObjectClass.name } returns "我修改你的值"
        Assert.assertEquals("我修改你的值", ObjectClass.name)
    }

    /***
     * mock私有方法
     */
    @Test
    fun test_getPrivateFunction() {
        mockkObject(ObjectClass)
        every { ObjectClass["getPrivateFunction"]() } returns "我是修改后的私有方法返回的"
        val objectFunction = ObjectClass.getObjectFunction();
        println(objectFunction)
        Assert.assertEquals("我是修改后的私有方法返回的", objectFunction)
    }

    @Test
    fun test_private_attr() {
//        mockkObject(ObjectClass)
//        every { ObjectClass getProperty "gender" } returns 1
//        Assert.assertEquals(1,ObjectClass.getPublicGender())
    }
}