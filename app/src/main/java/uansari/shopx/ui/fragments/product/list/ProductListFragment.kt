package uansari.shopx.ui.fragments.product.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uansari.shopx.R
import uansari.shopx.databinding.FragmentProductListBinding
import uansari.shopx.ui.adapters.ProductListAdapter

@AndroidEntryPoint
class ProductListFragment : Fragment(R.layout.fragment_product_list) {
    private val productListViewModel: ProductListViewModel by viewModels()
    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProductListBinding.bind(view)
        val productListAdapter = ProductListAdapter()
        binding.productListRecyclerview.adapter = productListAdapter

        productListViewModel.result.observe(viewLifecycleOwner) {
            productListAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}