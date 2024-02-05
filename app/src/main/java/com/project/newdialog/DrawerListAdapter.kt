package com.project.newdialog

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * Класс DrawerListAdapter, расширяющий ArrayAdapter и параметризованный String
 */
class DrawerListAdapter(
    context: Context,
    layoutResId: Int,
    items: List<String>
) : ArrayAdapter<String>(context, layoutResId, items) {

    private val mContext = context
    private val mLayoutResId = layoutResId
    private val mItems = items

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) : View {
        val holder: ViewHolder
        val itemView: View = convertView ?: LayoutInflater
            .from(mContext)
            .inflate(mLayoutResId, parent, false)

        holder = if (convertView == null) {
            ViewHolder().apply {
                textView = itemView.findViewById(R.id.item_text_view)
                itemView.tag = this
            }
        } else {
            convertView.tag as ViewHolder
        }

        if (mItems.isNotEmpty()) {
            val item: String = mItems[position]
            holder.textView?.text = item
        }

        return itemView
    }


    /**
     * Внутренний класс для хранения ссылок на виды внутри элемента
     */
    private class ViewHolder {
        var textView: TextView? = null
    }

}