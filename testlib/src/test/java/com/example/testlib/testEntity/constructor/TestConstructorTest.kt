package com.example.testlib.testEntity.constructor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.testlib.testEntity.constructor.InternalConstructor
import com.example.testlib.testEntity.constructor.TestConstructor
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class TestConstructorTest {

    @RelaxedMockK
    lateinit var context: Context

    @RelaxedMockK
    lateinit var inflateView: View

    @RelaxedMockK
    lateinit var inflater: LayoutInflater

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testConstuctor() {
        mockkConstructor(TestConstructor::class)
        every { anyConstructed<TestConstructor>().getNameStr() } returns "hahah"

        val nameStr = TestConstructor("sssss").getNameStr()
        Assert.assertEquals("hahah", nameStr)
    }


    @Test
    fun initView() {
        mockkStatic(LayoutInflater::class)
        mockkConstructor(InternalConstructor::class)
        every { LayoutInflater.from(any()) } returns inflater

        every { inflater.inflate(any<Int>(), any(), any()) } returns inflateView
        every { anyConstructed<InternalConstructor>().findViewById<TextView>(any()) } returns mockk()

        TestConstructor().runInternal(context)
    }
}