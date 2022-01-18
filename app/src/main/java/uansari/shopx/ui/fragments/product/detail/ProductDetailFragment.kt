package uansari.shopx.ui.fragments.product.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import uansari.shopx.R
import uansari.shopx.databinding.FragmentProductDetailBinding

@AndroidEntryPoint
class ProductDetailFragment : Fragment(R.layout.fragment_product_detail) {
    private val productDetailViewModel: ProductDetailViewModel by viewModels()
    private val args: ProductDetailFragmentArgs by navArgs()
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProductDetailBinding.bind(view)

        productDetailViewModel.getProductDetail(args.productId.toString())

        productDetailViewModel.productDetail.observe(viewLifecycleOwner) {
            Picasso.get().load(it.image).into(binding.productImg)
            binding.productTitle.text = it.title
            binding.productDescription.text = it.description
            binding.productRating.rating = it.rating.rate.toFloat()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}