package ru.prike.otus_fragment_lesson.start

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R

class TopFragment : Fragment(R.layout.fragment_top) {
    private var count = 1

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container, InnerFragment.newInstance(count), "inner")
                .addToBackStack(null)
                .commit()
            count++
        }

        view.findViewById<Button>(R.id.btn_remove_bottom_fragment).setOnClickListener {
//            val fragment = childFragmentManager.findFragmentById(R.id.container)
//            val fragment = childFragmentManager.findFragmentByTag("inner")
//            fragment?.let {
//                childFragmentManager.beginTransaction()
//                    .remove(fragment)
//                    .commit()
//            }
            if (childFragmentManager.backStackEntryCount > 0) {
                childFragmentManager.popBackStack()
            } else {
                requireActivity().onBackPressed()
            }
        }
    }
}