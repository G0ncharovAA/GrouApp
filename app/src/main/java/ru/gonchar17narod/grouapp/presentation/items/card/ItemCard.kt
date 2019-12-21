package ru.gonchar17narod.grouapp.presentation.items.card

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_card.view.*
import ru.gonchar17narod.grouapp.R


class ItemCard(
    val label: CharSequence
) : Item() {

    override fun getLayout(): Int = R.layout.item_card

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            item_text.text = context.getString(R.string.text_card).plus(label)
        }
    }
}