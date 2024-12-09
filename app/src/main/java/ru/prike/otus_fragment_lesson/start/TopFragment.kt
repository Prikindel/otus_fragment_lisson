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

        host = requireContext() as? Host
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        count = savedInstanceState?.getInt("count") ?: 1
        return inflater.inflate(
            R.layout.fragment_top,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container, InnerFragment.newInstance(count), if (count == 2) "second_tag" else null)
                .addToBackStack(if (count == 2) "second_back_stack" else null)
                .commit()

//            host?.onAdd(count)
//            ShareData.observer = count

//            sendCount(count)

            setCount(count)

            count++
        }

        view.findViewById<Button>(R.id.btn_remove_bottom_fragment).setOnClickListener {
//            val fragment = childFragmentManager.findFragmentByTag("second_tag")
//            if (fragment != null) {
//                childFragmentManager.beginTransaction()
//                    .remove(fragment)
//                    .commit()
//            }
            if (childFragmentManager.backStackEntryCount > 0) {
//                childFragmentManager.popBackStack("second_back_stack", 0)
                childFragmentManager.popBackStack()
                count--
                sendCount(count)
            } else {
                requireActivity().onBackPressed()
            }

        }
    }

    private fun sendCount(count: Int) {
        setFragmentResult(RESULT_KEY, bundleOf(RESULT_BUNDLE_KEY to count))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", count)
        super.onSaveInstanceState(outState)
    }

    interface Host {
        fun onAdd(count: Int)
        fun close()
    }
}