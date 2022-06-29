package com.max.nlpcpodcast.screen

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.max.nlpcpodcast.R
import com.max.nlpcpodcast.databinding.FragmentForgotPasswordBinding
import com.max.nlpcpodcast.databinding.FragmentSearchBinding
import com.max.nlpcpodcast.helper.showToast


class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendButton.setOnClickListener {
            performValidation()
        }
    }

    private fun performValidation() {

        val email = binding.forgetPasswordEmailInput.text.toString()


        when {
            email.isEmpty() -> {
                requireActivity().showToast("Enter your email")
                return
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                requireActivity().showToast("Invalid email")
                return

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}