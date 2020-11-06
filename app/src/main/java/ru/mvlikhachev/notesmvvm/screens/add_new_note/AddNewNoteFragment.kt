package ru.mvlikhachev.notesmvvm.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.mvlikhachev.notesmvvm.R
import ru.mvlikhachev.notesmvvm.databinding.FragmentAddNewNoteBinding
import ru.mvlikhachev.notesmvvm.model.AppNote
import ru.mvlikhachev.notesmvvm.utilits.APP_ACTIVITY
import ru.mvlikhachev.notesmvvm.utilits.showToast


class AddNewNoteFragment : Fragment() {


    private var _binding: FragmentAddNewNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewNoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNewNoteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteFragmentViewModel::class.java)
        mBinding.addNoteButton.setOnClickListener {
            val name = mBinding.inputNameNoteEditText.text.toString()
            val text = mBinding.inputTextNoteEditText.text.toString()
            if (name.isEmpty()){
                showToast(getString(R.string.toast_enter_name))
            } else {
                mViewModel.insert(AppNote(name = name,text = text)){
                    APP_ACTIVITY.navController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}