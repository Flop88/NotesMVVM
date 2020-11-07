package ru.mvlikhachev.notesmvvm.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_start.*
import ru.mvlikhachev.notesmvvm.R
import ru.mvlikhachev.notesmvvm.databinding.FragmentStartBinding
import ru.mvlikhachev.notesmvvm.utilits.*


class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        mBinding.btnRoom.setOnClickListener {
            mViewModel.initDatabase(TYPE_ROOM){
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }

        mBinding.btnFirebase.setOnClickListener {
            mBinding.inputEmailEditText.visibility = View.VISIBLE
            mBinding.inputPasswordEditText.visibility = View.VISIBLE
            mBinding.btnLogin.visibility = View.VISIBLE

            mBinding.btnLogin.setOnClickListener {
                val inputEmail = mBinding.inputEmailEditText.text.toString()
                val inputPassword = mBinding.inputPasswordEditText.text.toString()

                if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                    EMAIL = inputEmail
                    PASSWORD = inputPassword

                    mViewModel.initDatabase(TYPE_FIREBASE){
                        showToast("INIT OK")
//                        APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
                    }
                } else {
                    showToast(getString(R.string.toast_wrong_login_data))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}