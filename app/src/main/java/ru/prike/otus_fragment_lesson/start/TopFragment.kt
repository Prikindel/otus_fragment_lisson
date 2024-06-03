package ru.prike.otus_fragment_lesson.start

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import ru.prike.otus_fragment_lesson.R

class TopFragment : Fragment(R.layout.fragment_top) {
    var count = 1

    private var host: Host? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    count--
                } else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)

        host = context as? Host
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container, InnerFragment.newInstance(count), if (count == 2) "second_tag" else null)
                .addToBackStack( if (count == 2) "second_stack_tag" else null)
                .commit()
//            host?.onAdd(count)
//            SharedData.observer = count
            setFragmentResult(RESULT_KEY, bundleOf(RESULT_BUNDLE_KEY to count))
            count++
        }

        view.findViewById<Button>(R.id.btn_remove_bottom_fragment).setOnClickListener {
            if (childFragmentManager.backStackEntryCount > 0) {
                childFragmentManager.popBackStack()
                count--
                setFragmentResult(RESULT_KEY, bundleOf(RESULT_BUNDLE_KEY to count))
//                host?.close()
//                SharedData.observer = count
            } else {
                requireActivity().onBackPressed()
            }
        }
    }

    interface Host {
        fun onAdd(count: Int)
        fun close()
    }
}