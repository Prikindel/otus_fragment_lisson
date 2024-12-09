package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import ru.prike.otus_fragment_lesson.R

class BottomFragment : Fragment(R.layout.fragment_bottom) {
    private var textView: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text)

//        ShareData.observers.add {
//            changeText(it.toString())
//        }

//        setFragmentResultListener(RESULT_KEY) { _, bundle ->
//            val count = bundle.getInt(RESULT_BUNDLE_KEY, 0)
//            changeText(count.toString())
//        }

        listenerCount(::changeText)
    }

    fun changeText(text: String) {
        textView?.text = text
    }
}