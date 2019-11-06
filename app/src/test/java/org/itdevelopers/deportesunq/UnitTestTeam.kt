package org.itdevelopers.deportesunq

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
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

    @Test
    fun readStringFromContext_LocalizedString() {
//        Given a Context object retrieved from Roboelectric
        val teamUnderTest = Team()

//        .... when the string is returned from the object under test ...
        val result: String = teamUnderTest.alias

//        ... then the result should be the expected one
        assertThat(result).isEqualTo(FAKE_STRING)

    }

}