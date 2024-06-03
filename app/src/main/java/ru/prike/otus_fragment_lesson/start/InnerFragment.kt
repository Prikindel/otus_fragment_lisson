package ru.prike.otus_fragment_lesson.start

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R

class InnerFragment : Fragment(R.layout.fragment_inner) {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.text)
        val count = arguments?.getInt(COUNT_KEY, 0) ?: 0

        textView.text = "${textView.text} $count"
    }

    companion object {
        private const val COUNT_KEY = "count_key"

        fun newInstance(count: Int) = InnerFragment().apply {
            arguments = bundleOf(
                COUNT_KEY to count
            )
        }
    }
}