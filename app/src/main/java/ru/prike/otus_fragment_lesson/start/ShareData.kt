package ru.prike.otus_fragment_lesson.start

import kotlin.properties.Delegates

typealias Observer = (Int) -> Unit

object ShareData {
    var obsrvers = mutableListOf<Observer>()

    var observe: Int by Delegates.observable(0) { _, _, newValue ->
        obsrvers.forEach { it(newValue) }
    }
}