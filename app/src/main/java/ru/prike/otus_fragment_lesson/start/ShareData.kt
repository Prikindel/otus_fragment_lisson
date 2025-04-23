package ru.prike.otus_fragment_lesson.start

import kotlin.properties.Delegates

typealias StringObserver = (Int) -> Unit

object ShareData {
    var observers = mutableListOf<StringObserver>()

    var observe: Int by Delegates.observable(0) { _, _, newValue ->
        observers.forEach { it(newValue) }
    }
}