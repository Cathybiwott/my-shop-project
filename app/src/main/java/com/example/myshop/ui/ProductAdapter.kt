package com.example.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.databinding.ProductListBinding
import com.example.myshop.model.Products
//import com.example.products.databinding.ProductsListBinding
import com.squareup.picasso.Picasso
//import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductRvAdapter(var product: List<Products>):RecyclerView.Adapter<ProductRvAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsViewHolder {
        val binding=ProductListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentProduct=product.get(position)
        val binding=holder.binding
        binding.tvBrand.text=currentProduct.brand
        binding.tvCategory.text=currentProduct.category
        binding.tvId.text=currentProduct.id.toString()
        binding.tvPrice.text=currentProduct.price.toString()
        binding.tvDescription.text=currentProduct.description
        binding.tvRating.text=currentProduct.rating.toString()
        binding.tvStock.text=currentProduct.stock.toString()
        binding.tvThumbnail.text=currentProduct.thumbnail
        binding.tvTitle.text=currentProduct.title
        Picasso
            .get().load(currentProduct.thumbnail)
            .resize(80, 80)
            .centerInside()
//            .transform(CropCircleTransformation())
            .into(binding.ivAvatar)

    }
    override fun getItemCount(): Int {
        return product.size
    }

    class ProductsViewHolder(var binding: ProductListBinding):RecyclerView.ViewHolder(binding.root)
}