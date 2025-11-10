package ru.prike.otus_fragment_lesson.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {

    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun setCount(count: Int) {
        _count.value = count
    }

    fun clearCount() {
        _count.value = 0
    }
}