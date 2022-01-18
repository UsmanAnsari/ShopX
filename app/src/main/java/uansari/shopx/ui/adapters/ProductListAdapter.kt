package uansari.shopx.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uansari.shopx.R
import uansari.shopx.data.productlist.ProductListItem
import uansari.shopx.databinding.ProductListItemBinding
import uansari.shopx.ui.fragments.product.list.ProductListFragmentDirections


class ProductListAdapter :
    ListAdapter<ProductListItem, ProductListAdapter.ViewHolder>(ResultDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ProductListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = getItem(position)
        with(result) {
            Picasso.get().load(this.image).placeholder(R.drawable.ic_shopping_bag)
                .into(holder.productImg)
            holder.productTitle.text = this.title
            holder.productPrice.text = "$${this.price}"
            holder.productRating.rating = this.rating.rate.toFloat()
            holder.productRatingCount.text = this.rating.count.toString()
            holder.container.setOnClickListener {
                it.findNavController().navigate(
                    ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(
                        this.id
                    )
                )
            }
        }
    }


    inner class ViewHolder(private val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val container = binding.container
        val productImg = binding.productImg
        val productTitle = binding.productTitle
        val productPrice = binding.productPrice
        val productRating = binding.productRating
        val productRatingCount = binding.productRatingCount
    }
}

private class ResultDiffCallBack : DiffUtil.ItemCallback<ProductListItem>() {
    override fun areItemsTheSame(
        oldItem: ProductListItem,
        newItem: ProductListItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductListItem,
        newItem: ProductListItem
    ): Boolean {
        return oldItem == newItem
    }
}