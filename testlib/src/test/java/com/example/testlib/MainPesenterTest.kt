package com.example.testlib

import com.example.testlib.pesenter.MainPesenter
import io.mockk.mockkConstructor
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainPesenterTest {

    @Test
    fun test_for_toast() {
        val mainPesenter = MainPesenter()
        val add = mainPesenter.add(1, 1)
        assertEquals(2, add)
        assertEquals(2, mainPesenter.add2(1, 1))
        assertEquals(2, mainPesenter.add3(1, 1))
//        val mock = spyk(MockCls(), recordPrivateCalls = true)


    }

}