package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import ru.prike.otus_fragment_lesson.R

class BottomFragment : Fragment(R.layout.fragment_bottom) {

    private val textView by lazy { view?.findViewById<TextView>(R.id.text) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ShareData.observers.add {
            changeText(it.toString() + " ShareData")
        }

        observeResult {
            changeText(it.toString() + " FragmentResult")
        }
    }

    fun changeText(text: String) {
        textView?.text = text
    }
}