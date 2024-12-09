package ru.prike.otus_fragment_lesson.start

import kotlin.properties.Delegates

typealias StringObserver = (Int) -> Unit

object ShareData {
    var observers = mutableListOf<StringObserver>()

    var observer: Int by Delegates.observable(0) { property, oldValue, newValue ->
        observers.forEach { it(newValue) }
    }
}