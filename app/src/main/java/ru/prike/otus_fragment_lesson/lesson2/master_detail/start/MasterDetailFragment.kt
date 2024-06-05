package ru.prike.otus_fragment_lesson.lesson2.master_detail.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R
import ru.prike.otus_fragment_lesson.lesson2.master_detail.Item

class MasterDetailFragment : Fragment(R.layout.fragment_master_detail) {

    private var item: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getSerializable(ITEM_KEY) as? Item
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvBody: TextView = view.findViewById(R.id.tvBody)

        tvTitle.text = item?.title ?: "Title is null"
        tvBody.text = item?.body ?: "Body is null"
    }

    companion object {

        private const val ITEM_KEY = "item_key"

        fun newInstance(item: Item?): MasterDetailFragment = MasterDetailFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ITEM_KEY, item)
            }
        }
    }
}