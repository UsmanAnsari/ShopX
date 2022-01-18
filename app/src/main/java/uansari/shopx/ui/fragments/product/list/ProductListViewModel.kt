package uansari.shopx.ui.fragments.product.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uansari.shopx.data.productlist.ProductListResponse
import uansari.shopx.repositories.ApiRepository
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    ViewModel() {
    private val resultLiveData = MutableLiveData<ProductListResponse>()
    val result: LiveData<ProductListResponse> = resultLiveData

    init {
        viewModelScope.launch {
            val resultList = apiRepository.getProductList()
            delay(1000)
            resultLiveData.value = resultList
        }
    }
}