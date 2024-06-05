package ru.prike.otus_fragment_lesson.lesson2.master_detail.start

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
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
        val fragmentDetailContainer = findViewById<ViewGroup>(R.id.flDetailContainer)
        if (fragmentDetailContainer != null) {
            isTablet = true
        }
    }

    override fun onItemSelected(item: Item?) {
        val fragmentDetail = MasterDetailFragment.newInstance(item)
        if (isTablet) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flDetailContainer, fragmentDetail)
                .addToBackStack("list_to_detail")
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment1, fragmentDetail)
                .addToBackStack("list_to_detail")
                .commit()
        }
    }
}