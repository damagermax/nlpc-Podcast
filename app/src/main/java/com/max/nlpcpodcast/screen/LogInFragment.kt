package com.max.nlpcpodcast.screen

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.max.nlpcpodcast.R
import com.max.nlpcpodcast.databinding.FragmentLogInBinding
import com.max.nlpcpodcast.helper.showToast
import com.max.nlpcpodcast.viewmodel.AuthenticationViewModel


class LogInFragment : Fragment() {

    private var _binding: FragmentLogInBinding? = null
    private val binding get() = _binding!!

    private
    lateinit var authenticationViewModel: AuthenticationViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authenticationViewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)





        binding.forgotPasswordCta.setOnClickListener {
            val action = LogInFragmentDirections.actionLogInFragmentToForgotPasswordFragment()
            findNavController().navigate(action)
        }

        binding.loginButton.setOnClickListener {
//            val action =LogInFragmentDirections.actionLogInFragmentToBrowseCategoryFragment()
//            findNavController().navigate(action)
            performValidation()


        }

        binding.signUpCta.setOnClickListener {
            val action = LogInFragmentDirections.actionLogInFragmentToSignUpFragment()
            findNavController().navigate(action)
        }
    }


    private fun performValidation() {

        val email =binding.logInEmailInput.text.toString()
        val password=binding.logInPasswordInput.text.toString()


        when {
            email.isEmpty() -> {
                requireActivity().showToast( "Enter your email")

            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                requireActivity().showToast( "Invalid email")


            }
            password.isEmpty() -> {
                requireActivity().showToast(  "Enter your password")

            }

            password.length > 8 -> {
                requireActivity().showToast("Password is weak")

            }
        }


    }


    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

}