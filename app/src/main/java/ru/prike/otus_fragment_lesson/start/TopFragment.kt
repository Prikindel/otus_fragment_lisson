package ru.prike.otus_fragment_lesson.start

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R

class TopFragment : Fragment() {
    var count = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {

            count++
        }

        view.findViewById<Button>(R.id.btn_remove_bottom_fragment).setOnClickListener {

        }
    }
}