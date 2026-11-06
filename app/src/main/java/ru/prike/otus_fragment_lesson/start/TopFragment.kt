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
    var count = 0

    private val host: Host?
        get() = requireActivity() as? Host

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                removeFragment { isEnabled = false }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        count = savedInstanceState?.getInt(COUNT_KEY) ?: 0
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {
            addFragment()
        }

        view.findViewById<Button>(R.id.btn_remove_bottom_fragment).setOnClickListener {
            removeFragment()
        }
    }

    private fun addFragment() {
        count++
        notifyChange()
        val innerFragment = InnerFragment.newInstance(count)
        childFragmentManager.beginTransaction()
            .replace(R.id.container, innerFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun removeFragment(
        onExit: () -> Unit = {}
    ) {
        if (childFragmentManager.backStackEntryCount > 0) {
            count--
            notifyChange()
            childFragmentManager.popBackStack()
        } else {
            onExit()
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun notifyChange() {
//        if (count > 0) host?.onChange(count) else host?.close()
//        ShareData.oberve = count
        sendResult(count)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, count)
    }

    interface Host {
        fun onChange(count: Int)
        fun close()
    }

    companion object {
        private val COUNT_KEY = "count"
    }
}