package ru.prike.otus_fragment_lesson.lesson2.master_detail

import java.io.Serializable

class Item(val title: String, val body: String) : Serializable {

    companion object {
        val items: ArrayList<Item>
            get() {
                val items = ArrayList<Item>()
                items.add(Item("Item 1", "This is the first item"))
                items.add(Item("Item 2", "This is the second item"))
                items.add(Item("Item 3", "This is the third item"))
                return items
            }
    }

    override fun toString(): String {
        return title
    }
}