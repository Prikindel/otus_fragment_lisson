package ru.prike.otus_fragment_lesson.finish

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R

class TopFragmentFinish : Fragment() {
    var count = 1

    //lateinit var host: Host
    //val viewModel: ExampleViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //host = context as? Host ?: error("Activity должна реализовывать интерфейс Host")




        val callback = object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_add_bottom_fragment).setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container, InnerFragmentFinish.create(count), if (count == 2) "second_tag" else null)
                .addToBackStack(if (count == 2) "second_tag_transaction" else null)
                .commit()

            /*   val result = Bundle()
               result.putInt("value", count)
               parentFragmentManager.setFragmentResult("top_result", result)*/

            //viewModel.passNewValue(count)

//            MySomeSharedData.countValues = count

            //host.onCountIncremented(count)

            count++
        }

        view.findViewById<Button>(R.id.btn_remove_bottom_fragment).setOnClickListener {
            if (childFragmentManager.backStackEntryCount > 0) {
                childFragmentManager.popBackStack()
                //count--
            } else {
                //host.close()
            }
        }
    }

    interface Host {
        fun onCountIncremented(count: Int)
        fun close()
    }
}