package ru.prike.otus_fragment_lesson.start

import kotlin.properties.Delegates

typealias Observer = (Int) -> Unit

object ShareData {
    var observers = mutableListOf<Observer>()

    var observe: Int by Delegates.observable(0) { _, _, newValue ->
        observers.forEach { it(newValue) }
    }
}