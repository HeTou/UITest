package com.example.testlib

import com.example.testlib.pesenter.MainPesenter
import junit.framework.Assert.assertEquals
import org.junit.Test

class MainPesenter22Test {

    @Test
    fun test_for_toast() {
        val mainPesenter = MainPesenter()
        assertEquals(
            2, mainPesenter.add(1, 1)
        )
        assertEquals(
            2, mainPesenter.add2(1, 1)
        )
        assertEquals(
            2, mainPesenter.add3(1, 1)
        )
    }
}