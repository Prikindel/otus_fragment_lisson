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

        observeResult {
            setCount(it)
        }

//        ShareData.obsrvers.add { textView?.text = "Количество вложенных фрагментов: $it" }
    }

    fun setCount(count: Int) {
        textView?.text = "Количество вложенных фрагментов: $count"
    }

    fun clear() {
        textView?.text = "Я нижний фрагмент"
    }

}