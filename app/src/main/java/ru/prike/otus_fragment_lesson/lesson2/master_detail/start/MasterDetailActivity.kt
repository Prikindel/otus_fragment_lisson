package ru.prike.otus_fragment_lesson.lesson2.master_detail.start

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import ru.prike.otus_fragment_lesson.R
import ru.prike.otus_fragment_lesson.lesson2.master_detail.Item

class MasterDetailActivity : FragmentActivity(), MasterDetailListFragment.OnItemSelectedListener {

    private var isTablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_detail)
        determinePaneLayout()
    }

    private fun determinePaneLayout() {
//        val fragmentDetailContainer = findViewById<ViewGroup>(R.id.flDetailContainer)
//        if (fragmentDetailContainer != null) {
//            isTablet = true
//        }
        isTablet = resources.getBoolean(R.bool.is_tablet)
        println("isTablet = $isTablet")
    }

    override fun onItemSelected(item: Item?) {
        if (isTablet) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flDetailContainer, MasterDetailFragment.newInstance(item))
//                .addToBackStack("")
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment1, MasterDetailFragment.newInstance(item))
                .addToBackStack("")
                .commit()
        }
    }

    // Если в layout контейнеры в разметке для телефона и в разметке для планшета имеют
// одинаковый id, то можем делать вот так:

//    override fun onItemSelected(item: Item?) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment1, MasterDetailFragment.newInstance(item))
//            .addToBackStack("")
//            .commit()
//    }
}