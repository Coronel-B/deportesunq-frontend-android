package org.itdevelopers.deportesunq.net

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.itdevelopers.deportesunq.model.Competitions
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object {

        private const val BASE_URL: String = "http://private-f98755-deportesunq.apiary-mock.com/"
        private var retrofit: Retrofit? = null

        val client: Retrofit
            get() {

                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BASIC
                val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

                val gson: Gson = GsonBuilder()
                    .registerTypeAdapter(
                        Competitions::class.java,
                        JsonCompetitionsDeserializer())
                    .create()

                //TODO: Parametrizar la clase para que reciba un gson
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                }
                return retrofit!!
            }
    }

}