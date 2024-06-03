package ru.prike.otus_fragment_lesson.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.prike.otus_fragment_lesson.R

class MainActivity : AppCompatActivity() {
    private lateinit var topFragment: TopFragment
    private lateinit var bottomFragment: BottomFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            topFragment = TopFragment()
            bottomFragment = BottomFragment()

        } else {
            // topFragment = supportFragmentManager.findFragmentByTag("top") as TopFragment
        }
    }
}