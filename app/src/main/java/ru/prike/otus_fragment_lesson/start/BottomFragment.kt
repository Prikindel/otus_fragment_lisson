package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import ru.prike.otus_fragment_lesson.R

class BottomFragment : Fragment(R.layout.fragment_bottom) {

    private var textView: TextView? = null

    private val viewModel: BlankViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text)

//        observeResult {
//            setCount(it)
//        }

        viewModel.count.observe(viewLifecycleOwner) {
            textView?.text = if (it > 0) "Количество вложенных фрагментов: $it" else "Я нижний фрагмент"
        }
        println("Bottom viewModel ${viewModel}")

//        ShareData.obsrvers.add { textView?.text = "Количество вложенных фрагментов: $it" }
    }

    fun setCount(count: Int) {
        textView?.text = "Количество вложенных фрагментов: $count"
    }

    fun clear() {
        textView?.text = "Я нижний фрагмент"
    }

}