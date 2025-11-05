package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R

class InnerFragment : Fragment(R.layout.fragment_inner) {

    private val count by lazy { arguments?.getInt(COUNT_KEY) ?: 0 }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.text).text = "Я вложенный фрагмент: $count"
    }

    companion object {
        private const val COUNT_KEY = "count"

        fun newInstance(count: Int) = InnerFragment().apply {
            arguments = bundleOf(COUNT_KEY to count)
        }
    }

}