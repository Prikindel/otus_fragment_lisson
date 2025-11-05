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

class TopFragment : Fragment() {
    private var count = 1

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    count--
                } else {
                    isEnabled = false
                    requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_top, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {
            openInnerFragment()
            count++
        }

        view.findViewById<Button>(R.id.btn_remove_bottom_fragment).setOnClickListener {
            removeInnerFragment()
        }
    }

    private fun openInnerFragment() {
        val innerFragment = InnerFragment.newInstance(count)
        sendResult(count)
//        ShareData.observe = count
//        (requireActivity() as Host).onAdd(count)
        childFragmentManager.beginTransaction()
            .replace(R.id.container, innerFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun removeInnerFragment() {
        if (childFragmentManager.backStackEntryCount > 0) {
            childFragmentManager.popBackStack()
            count--
            sendResult(count - 1)
//            ShareData.observe = count - 1
//            if (count <= 1) (requireActivity() as Host).close()
//            else (requireActivity() as Host).onAdd(count - 1)
        } else {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    interface Host {
        fun onAdd(count: Int)
        fun close()
    }
}