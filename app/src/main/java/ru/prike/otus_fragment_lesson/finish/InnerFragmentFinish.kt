package ru.prike.otus_fragment_lesson.finish

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R

class InnerFragmentFinish : Fragment(R.layout.fragment_inner) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.text)
        val value = arguments?.getInt(ARG_VALUE)
        text.text = "${text.text} ${value.toString()}"
    }

    companion object {

        private const val ARG_VALUE = "value"

        fun create(value: Int): InnerFragmentFinish {
            val fragment = InnerFragmentFinish()
            val arguments = Bundle()
            arguments.putInt(ARG_VALUE, value)
            fragment.arguments = arguments
            return fragment
        }
    }
}