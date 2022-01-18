package uansari.shopx.repositories

import uansari.shopx.api.FakeStoreAPI
import javax.inject.Inject

class ApiRepository @Inject constructor(private val fakeStoreAPI: FakeStoreAPI) {
    suspend fun getProductList() = fakeStoreAPI.getProductList()
    suspend fun getProductDetail(id: String) = fakeStoreAPI.getProductDetail(id)
}