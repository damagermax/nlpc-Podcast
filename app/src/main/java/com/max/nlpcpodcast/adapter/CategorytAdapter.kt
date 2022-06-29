package com.max.nlpcpodcast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.max.nlpcpodcast.R
import com.max.nlpcpodcast.model.CategoryModel
import com.squareup.picasso.Picasso

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var mCategoryList = emptyList<CategoryModel>()


    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.browseCategoryItemImage)
        val nameTextView: TextView = view.findViewById(R.id.browseCategoryItemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        return CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.browse_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategoryList = mCategoryList[position]

        holder.nameTextView.text = currentCategoryList.name
        Picasso.get().load(currentCategoryList.imageUrl).centerCrop().fit().into(holder.imageView)


    }


    override fun getItemCount() = mCategoryList.size
    fun setData(categoryData: List<CategoryModel>) {
        mCategoryList = categoryData
    }
}