package ru.prike.otus_fragment_lesson.finish

import androidx.fragment.app.Fragment
import ru.prike.otus_fragment_lesson.R

class BottomFragmentFinish : Fragment(R.layout.fragment_bottom) {
    /*lateinit var textView: TextView
    private val viewModel: ExampleViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.text)

        *//*   parentFragmentManager.setFragmentResultListener("top_result", this) { _, result ->
               val value = result.getInt("value")
               textView.text = "Value: $value"
           }*//*

     *//*   MySomeSharedData.prop1Observers.add {
            textView.text = "Value: $it"
        }*//*

        *//*viewModel.counterValues.observe(viewLifecycleOwner) {
            textView.text = "Value: $it"
        }*//*

    }

    fun onCounterIncremented(counter: Int) {
        textView.text = "Value: $counter"
    }*/
}