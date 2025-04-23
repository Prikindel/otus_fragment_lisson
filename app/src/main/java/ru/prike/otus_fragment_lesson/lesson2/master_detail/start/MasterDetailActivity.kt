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
        isTablet = resources.getBoolean(R.bool.isTablet)
//        val fragmentDetailContainer = findViewById<ViewGroup>(R.id.flDetailContainer)
//        if (fragmentDetailContainer != null) {
//            isTablet = true
//        } else {
//            isTablet = false
//        }
    }

    override fun onItemSelected(item: Item?) {
        val fragmentDetail = MasterDetailFragment.newInstance(item)
//        val container = if (isTablet) R.id.flDetailContainer else R.id.fragment1

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment1, fragmentDetail)
            .addToBackStack(null)
            .commit()
    }
}