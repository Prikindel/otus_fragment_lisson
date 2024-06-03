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
            supportFragmentManager.beginTransaction()
                .replace(R.id.top_container, topFragment, "top")
                .add(R.id.bottom_container, bottomFragment)
                .commit()
        } else {
//             topFragment = supportFragmentManager.findFragmentByTag("top") as TopFragment
        }
    }

    override fun onAdd(count: Int) {
        bottomFragment.changeText("$count")
    }

    override fun close() {
        finish()
    }
}