package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import ru.prike.otus_fragment_lesson.R

class BottomFragment : Fragment(R.layout.fragment_bottom) {

    private val textView by lazy { requireView().findViewById<TextView>(R.id.text) }

    private val observer: Observer = {
        if (it > 0) setCount(it) else clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeResult { count ->
            if (count > 0) setCount(count) else clear()
        }

//        ShareData.observers.add(observer)
    }

    fun setCount(count: Int) {
        textView.text = "Колличество вложенных\nфрагментов: $count"
    }

    fun clear() {
        textView.text = "Я нижний фрагмент"
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        ShareData.observers.remove(observer)
    }
}