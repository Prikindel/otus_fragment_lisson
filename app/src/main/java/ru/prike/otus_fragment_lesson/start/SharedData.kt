package ru.prike.otus_fragment_lesson.start

import kotlinx.coroutines.flow.asFlow
import kotlin.properties.Delegates

typealias StringObserver = (Int) -> Unit

object SharedData {
    var count = mutableListOf<StringObserver>()

    var observer: Int by Delegates.observable(0) { prod, old, new ->
        count.forEach { it(new) }
    }
}