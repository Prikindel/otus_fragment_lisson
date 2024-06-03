package ru.prike.otus_fragment_lesson.finish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.prike.otus_fragment_lesson.R

class MainActivityFinish : AppCompatActivity(), TopFragmentFinish.Host {
    private lateinit var topFragment: TopFragmentFinish
    private lateinit var bottomFragment: BottomFragmentFinish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            topFragment = TopFragmentFinish()
            bottomFragment = BottomFragmentFinish()
            supportFragmentManager.beginTransaction()
                .replace(R.id.top_container, topFragment, "top")
                .replace(R.id.bottom_container, bottomFragment)
                .commit()
        } else {
            // topFragment = supportFragmentManager.findFragmentByTag("top") as TopFragment
        }

        /* supportFragmentManager.setFragmentResultListener("top_result", this) { _, result ->
             val value = result.get("value")
             Toast.makeText(this, "RESUUUULT $value", Toast.LENGTH_SHORT).show()
         }*/
        /*viewModel.selectedString.observe(this) {
            Toast.makeText(this@MainActivity, it.heroName, Toast.LENGTH_SHORT).show()
        }*/
    }

    /* override fun onBackPressed() {
         if (topFragment.childFragmentManager.backStackEntryCount > 0) {
             topFragment.childFragmentManager.popBackStack()
         } else {
             super.onBackPressed()
         }
     }*/

    /* override fun onBackPressed() {
         if (topFragment.childFragmentManager.backStackEntryCount > 0) {
             topFragment.childFragmentManager.popBackStack()
         } else {
             super.onBackPressed()
         }
     }*/

    override fun onCountIncremented(count: Int) {
        //bottomFragment.onCounterIncremented(count)
    }

    override fun close() {
        super.onBackPressed()
    }
}