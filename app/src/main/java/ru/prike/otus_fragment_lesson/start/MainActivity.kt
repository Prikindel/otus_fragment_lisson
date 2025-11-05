package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.prike.otus_fragment_lesson.R

class MainActivity : AppCompatActivity(), TopFragment.Host {
    private lateinit var topFragment: TopFragment
    private lateinit var bottomFragment: BottomFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            topFragment = TopFragment()
            bottomFragment = BottomFragment()
        } else {
            topFragment = supportFragmentManager.findFragmentByTag("top") as TopFragment
            bottomFragment = supportFragmentManager.findFragmentById(R.id.bottom_container) as BottomFragment
//            bottomFragment = BottomFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.top_container, topFragment, "top")
            .replace(R.id.bottom_container, bottomFragment)
            .commit()
    }

    override fun onAdd(count: Int) {
        bottomFragment.setCount(count)
    }

    override fun close() {
        bottomFragment.clear()
    }
}