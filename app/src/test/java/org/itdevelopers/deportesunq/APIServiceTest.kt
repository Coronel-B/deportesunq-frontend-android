package org.itdevelopers.deportesunq

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.itdevelopers.deportesunq.services.CompetitionsApiService
import org.itdevelopers.deportesunq.model.Competitions
import org.itdevelopers.deportesunq.net.API
import org.itdevelopers.deportesunq.net.JsonCompetitionsDeserializer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * OBS: No testear como viene el json sino qué hago con el json y el comportamiento de la app
 */
class APIServiceTest {

    //    Create server
    private var mockWebServer = MockWebServer()

    private lateinit var apiService: Retrofit

    @Before
    fun setup() {
//        Start server
        mockWebServer.start()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val gson: Gson = GsonBuilder()
            .registerTypeAdapter(Competitions::class.java, JsonCompetitionsDeserializer())
            .create()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CompetitionsApiService::class.java)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun test() {

    }


}