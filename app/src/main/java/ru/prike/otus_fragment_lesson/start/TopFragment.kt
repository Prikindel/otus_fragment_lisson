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
    private var count = 0

    private var host: Host? = null

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

        host = requireActivity() as? Host
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {
            count++
            childFragmentManager.beginTransaction()
                .replace(R.id.container, InnerFragment.newInstance(count), "inner")
                .addToBackStack(null)
                .commit()

            sendCount(count)
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
                count--
                sendCount(count)
            } else {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun sendCount(count: Int) {
//        host?.onAdd(count)
//        ShareData.observe = count

        sendResult(count)
    }

    interface Host {
        fun onAdd(count: Int)
        fun close()
    }
}