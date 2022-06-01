package com.example.testlib

import junit.framework.Assert.assertEquals
import org.junit.Test

class MainPesenter22Test {


    @Test
    fun test_for_toast() {
        val mainPesenter = MainPesenter()
        assertEquals(
            2, mainPesenter.add(1, 1)
        )
    }
}