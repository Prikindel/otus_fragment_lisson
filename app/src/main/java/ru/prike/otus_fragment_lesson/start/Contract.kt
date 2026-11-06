package ru.prike.otus_fragment_lesson.start

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

private const val FRAGMENT_REQUEST_KEY = "request_key"
private const val RESULT = "result"

fun Fragment.sendResult(count: Int) {
    val result = bundleOf(RESULT to count)
    setFragmentResult(
        requestKey = FRAGMENT_REQUEST_KEY,
        result = result
    )
}

fun Fragment.observeResult(callback: (Int) -> Unit) {
    setFragmentResultListener(FRAGMENT_REQUEST_KEY) { _, bundle ->
        val count = bundle.getInt(RESULT, 0)
        callback(count)
    }
}
