package uansari.shopx.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uansari.shopx.utils.Constants.BASE_URL

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: FakeStoreAPI by lazy {
        retrofit.create(FakeStoreAPI::class.java)
    }
}