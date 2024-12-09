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

//        when {
//            topFragment == null && bottomFragment == null
//                    || savedInstanceState == null -> {
//                topFragment = TopFragment()
//                bottomFragment = BottomFragment()
//            }
////            savedInstanceState != null -> {
////                topFragment = supportFragmentManager.findFragmentByTag("top") as TopFragment
////            }
//            topFragment == null -> {
//                topFragment = TopFragment()
//            }
//            bottomFragment == null -> {
//                bottomFragment = BottomFragment()
//            }
//            else -> {
//                topFragment = supportFragmentManager.findFragmentByTag("top") as TopFragment
//            }
//        }

        if (savedInstanceState == null) {
            topFragment = TopFragment()
            bottomFragment = BottomFragment()

            supportFragmentManager.beginTransaction()
                .replace(R.id.top_container, topFragment, "top")
                .replace(R.id.bottom_container, bottomFragment)
                .commit()
        } else {
            // topFragment = supportFragmentManager.findFragmentByTag("top") as TopFragment
        }

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.top_container, topFragment!!, "top")
//            .add(R.id.bottom_container, bottomFragment!!)
//            .commit()
    }

    override fun onAdd(count: Int) {
        bottomFragment.changeText(count.toString())
    }

    override fun close() {
        finish()
    }
}