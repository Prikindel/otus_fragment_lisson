package ru.prike.otus_fragment_lesson.lesson2.master_detail.finish

import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import ru.prike.otus_fragment_lesson.R
import ru.prike.otus_fragment_lesson.lesson2.master_detail.Item

class MasterDetailFinishActivity : FragmentActivity(), MasterDetailListFinishFragment.OnItemSelectedListener {

    private var isTablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master_detail)
        determinePaneLayout()
    }

    private fun determinePaneLayout() {
        val fragmentItemDetail: FrameLayout? = findViewById(R.id.flDetailContainer)
        if (fragmentItemDetail != null) {
            isTablet = true
        }
    }

    override fun onItemSelected(item: Item?) {
        val fragmentItem: MasterDetailFinishFragment = MasterDetailFinishFragment.newInstance(item)
        if (isTablet) {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.flDetailContainer, fragmentItem)
            ft.commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment1, fragmentItem)
                .addToBackStack("simple_fragment")
                .commit()
        }
    }
}