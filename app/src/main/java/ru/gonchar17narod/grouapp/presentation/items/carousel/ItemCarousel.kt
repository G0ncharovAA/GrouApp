package ru.gonchar17narod.grouapp.presentation.items.carousel

import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_carousel.view.*
import ru.gonchar17narod.grouapp.R
import ru.gonchar17narod.grouapp.presentation.items.card.ItemCard


class ItemCarousel(
    val label: CharSequence
) : Item() {

    override fun getLayout(): Int = R.layout.item_carousel

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            carousel_recycler_view.adapter =
                GroupAdapter<GroupieViewHolder>().apply {
                    addAll(List(8) { ItemCard(it.toString()) })
                }
        }
    }
}