package org.itdevelopers.deportesunq

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.itdevelopers.deportesunq.model.Competitions
import org.itdevelopers.deportesunq.net.JsonCompetitionsDeserializer
import org.itdevelopers.deportesunq.services.CompetitionsApiService
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit


/**
 * OBS: No testear como viene el json sino qué hago con el json y el comportamiento de la app
 */
class APIServiceTest {

    //    Create server
    private var mockWebServer = MockWebServer()

    private lateinit var competitionsApiService: CompetitionsApiService

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

        competitionsApiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("competitions/"))
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
    fun testRequestCompetitions() {
//        Assign
        val response = MockResponse()
            .addHeader("Content-Type", "application/json; charset=utf-8")
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody("{}")

        response.throttleBody(1024, 1, TimeUnit.SECONDS);

        mockWebServer.enqueue(response)

//        Act
//        val champion = competitionsApiService.getCompetitions()

//        Verify requests by their method, path, HTTP version, body, and headers.
        val request: RecordedRequest = mockWebServer.takeRequest()
//        assertEquals("/competitions/", request.path);
        assertEquals("{}", request.body.readUtf8());
        assertTrue(true)
    }

    /**
     * Helper function which will load JSON from
     * the path specified
     * Source: https://android.jlelse.eu/unit-test-api-calls-with-mockwebserver-d4fab11de847
     *
     * @param path : Path of JSON file
     * @return json : JSON from file at given path
     */
    fun getJson(path : String) : String {
        // Load the JSON response
        val uri = this.javaClass.classLoader?.getResource(path)
        val file = File(uri?.path!!)
        return String(file.readBytes())
    }

}