package ru.prike.otus_fragment_lesson.start

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

private const val FRAGMENT_REQUEST_KEY = "request_key"
private const val RESULT = "result"

fun Fragment.sendResult(count: Int) {
    setFragmentResult(FRAGMENT_REQUEST_KEY, bundleOf(RESULT to count))
}

fun Fragment.observeResult(callback: (Int) -> Unit) {
    setFragmentResultListener(FRAGMENT_REQUEST_KEY) { _, bundle ->
        val count = bundle.getInt(RESULT)
        callback(count)
    }
}