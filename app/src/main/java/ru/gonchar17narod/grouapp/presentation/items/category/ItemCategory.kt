package ru.gonchar17narod.grouapp.presentation.items.category

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_category.view.*
import ru.gonchar17narod.grouapp.R
import ru.gonchar17narod.grouapp.presentation.items.card.ItemCard
import ru.gonchar17narod.grouapp.presentation.items.carousel.ItemCarousel


class ItemCategory : Item() {

    override fun getLayout(): Int = R.layout.item_category

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            category_recycler_view.adapter =
                GroupAdapter<GroupieViewHolder>().apply {
                    addAll(List(4) { ItemCard(it.toString()) })
                    addAll(List(8) { ItemCarousel(it.toString()) })
                }
        }
    }
}