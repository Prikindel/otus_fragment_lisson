package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.prike.otus_fragment_lesson.R

class BottomFragment : Fragment(R.layout.fragment_bottom) {
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text)
        SharedData.count.add {
            changeText(it.toString())
        }

        setFragmentResultListener(RESULT_KEY) { _, bundle ->
            val count = bundle.getInt(RESULT_BUNDLE_KEY, 0)
            changeText(count.toString())
        }
    }

    fun changeText(text: String) {
        textView.text = text
    }
}