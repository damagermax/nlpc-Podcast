package com.max.nlpcpodcast.screen

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.max.nlpcpodcast.R
import com.max.nlpcpodcast.databinding.FragmentSignUpBinding
import com.max.nlpcpodcast.helper.showToast


class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginCta.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignUpFragmentToLogInFragment()
            findNavController().navigate(action)

        }

        binding.signUpButton.setOnClickListener {
//            val action = SignUpFragmentDirections.actionSignUpFragmentToBrowseCategoryFragment()
//            findNavController().navigate(action)
            performValidation()
        }
    }

    private fun performValidation() {

        val email = binding.signUpEmailInput.text.toString()
        val password = binding.signUpPasswordInput.text.toString()
        val name = binding.signUpNameInput.text.toString()
        val phoneNumber = binding.signUpNumberInput.text.toString()


        when {

            name.isEmpty() -> {
                requireActivity().showToast("Enter your name")
                return
            }
            phoneNumber.isEmpty() -> {
                requireActivity().showToast("Enter your phone number")
                return

            }
            email.isEmpty() -> {
                requireActivity().showToast("Enter your email")
                return

            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                requireActivity().showToast("Invalid email")
                return


            }
            password.isEmpty() -> {
                requireActivity().showToast("Enter your password")
                return

            }

            password.length > 8 -> {
                requireActivity().showToast("Password is weak")
                return

            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}