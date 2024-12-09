package ru.prike.otus_fragment_lesson.start

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

private val RESULT_KEY_THIS = "result_key"
private val RESULT_KEY_OTHER = "result_key_other"

fun Fragment.listenerCount(
    listener: (String) -> Unit
) {
    setFragmentResultListener(RESULT_KEY_THIS) { _, bundle ->
        val count = bundle.getInt(RESULT_KEY_OTHER)
        listener(count.toString())
    }
}

fun Fragment.setCount(count: Int) {
    setFragmentResult(RESULT_KEY_THIS, bundleOf(RESULT_KEY_OTHER to count))
}