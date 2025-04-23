package ru.prike.otus_fragment_lesson.start

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

private const val RESULT_KEY = "result"
private const val RESULT_BUNDLE_KEY = "result_bundle"

fun Fragment.sendResult(count: Int) {
    setFragmentResult(RESULT_KEY, bundleOf(RESULT_BUNDLE_KEY to count))
}

fun Fragment.observeResult(callback: (Int) -> Unit) {
    setFragmentResultListener(RESULT_KEY) { _, bundle ->
        val count = bundle.getInt(RESULT_BUNDLE_KEY, 0)
        callback(count)
    }
}