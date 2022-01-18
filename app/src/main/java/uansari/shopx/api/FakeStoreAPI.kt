package uansari.shopx.api

import retrofit2.http.GET
import retrofit2.http.Path
import uansari.shopx.data.productlist.ProductListItem
import uansari.shopx.data.productlist.ProductListResponse

interface FakeStoreAPI {
    @GET("products")
    suspend fun getProductList(): ProductListResponse

    @GET("products/{product_id}")
    suspend fun getProductDetail(@Path("product_id") id: String): ProductListItem

}