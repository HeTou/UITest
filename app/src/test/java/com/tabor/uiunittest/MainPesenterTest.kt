package com.tabor.uiunittest

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

class MainPesenterTest {


    @Test
    fun test_for_toast() {
        val mainPesenter = MainPesenter()
        assertEquals(
            2, mainPesenter.add(1, 1)
        )
    }
}