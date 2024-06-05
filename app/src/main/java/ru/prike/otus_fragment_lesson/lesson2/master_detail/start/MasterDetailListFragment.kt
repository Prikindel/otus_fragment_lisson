package ru.prike.otus_fragment_lesson.lesson2.master_detail.start

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R
import ru.prike.otus_fragment_lesson.lesson2.master_detail.Item

class MasterDetailListFragment : Fragment() {

    private var listener: OnItemSelectedListener? = null

    interface OnItemSelectedListener {
        fun onItemSelected(item: Item?)
    }

    override fun onAttach(activity: Context) {
        super.onAttach(activity)
        listener = if (activity is OnItemSelectedListener) {
            activity
        } else {
            throw ClassCastException(
                activity.toString()
                    + " must implement ItemsListFragment.OnItemSelectedListener"
            )
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(
            R.layout.fragment_master_detail_items_list, container,
            false
        )

        val listContainer = view.findViewById<LinearLayout>(R.id.list_container)
        Item.items.forEach { item ->
            listContainer.addItem(item)
        }

        return view
    }

    private fun LinearLayout.addItem(item: Item) {
        val viewItem: TextView = layoutInflater.inflate(
            R.layout.simple_item,
            null,
            false
        ) as TextView

        viewItem.text = item.title
        viewItem.setOnClickListener {
            listener?.onItemSelected(item)
        }

        addView(viewItem)
    }
}