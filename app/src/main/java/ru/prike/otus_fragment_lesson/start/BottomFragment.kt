package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import ru.prike.otus_fragment_lesson.R

class BottomFragment : Fragment(R.layout.fragment_bottom) {

    private val textView: TextView by lazy { requireView().findViewById(R.id.text) }

    private val viewModel: BlankViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ShareData.observers.add { setCount(it) }

//        observeResult {
//            if (it > 0) setCount(it)
//            else cleat()
//        }
        viewModel.count.observe(viewLifecycleOwner) { count ->
            if (count > 0) setCount(count)
            else cleat()
        }

    }

    fun setCount(count: Int) {
        textView.text = "Колличество вложенных\nфрагментов: $count"
    }

    fun cleat() {
        textView.text = "Я нижний фрагмент"
    }
}