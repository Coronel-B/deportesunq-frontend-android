package org.itdevelopers.deportesunq

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test

import org.junit.Assert.*
import kotlin.Any as Any1

private const val FAKE_STRING = "Hello world"

class UnitTestTeam {

    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun getId() {
        assertEquals(0, 0)
    }

    @Test
    fun getAlias() {
        assertEquals("UNQ", "UNQ")
    }

    @Test
    fun getFullName() {
        assertEquals("Universidad Nacional de Quilmes", "Universidad Nacional de Quilmes")
    }

}