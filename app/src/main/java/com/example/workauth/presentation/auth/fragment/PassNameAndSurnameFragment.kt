package com.example.workauth.presentation.auth.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.workauth.R
import com.example.workauth.databinding.FragmentPassNameAndSurnameBinding
import com.example.workauth.presentation.preference.AppPreference


class PassNameAndSurnameFragment : Fragment() {

    private var _binding: FragmentPassNameAndSurnameBinding? = null
    private val binding: FragmentPassNameAndSurnameBinding get() = _binding!!

    private var _preference: AppPreference? = null
    private val preference: AppPreference get() = _preference!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentPassNameAndSurnameBinding.inflate(inflater, container, false)
        _preference = AppPreference(requireContext())
        setUp()


        return binding.root
    }

    private fun setUp() { with(binding)
    {
        numberPhoneID.text = preference.getNumber()

        inputNameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val name = inputNameEditText.text?.length
                val surname = inputSurnameEditText.text?.length
                val lastname = inputLastnameEditText.text?.length
                when {
                    name != null && surname != null && lastname != null && name > 0 && surname > 0 && lastname > 0 -> {
                        enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_action))
                    }

                    else -> {
                        enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_default))
                    }
                }
            }
        })

        inputSurnameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val name = inputNameEditText.text?.length
                val surname = inputSurnameEditText.text?.length
                val lastname = inputLastnameEditText.text?.length
                when {
                    name != null && surname != null && lastname != null && name > 0 && surname > 0 && lastname > 0 -> {
                        enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_action))
                    }

                    else -> {
                        enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_default))
                    }
                }
            }
        })

        inputLastnameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val name = inputNameEditText.text?.length
                val surname = inputSurnameEditText.text?.length
                val lastname = inputLastnameEditText.text?.length
                when {
                    name != null && surname != null && lastname != null && name > 0 && surname > 0 && lastname > 0 -> {
                        enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_action))
                    }

                    else -> {
                        enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_default))
                    }
                }
            }
        })

        enterButton.setOnClickListener {
            val name = inputNameEditText.text?.length
            val surname = inputSurnameEditText.text?.length
            val lastname = inputLastnameEditText.text?.length
            when {
                name == 0 -> {
                    neceserlyName.setTextColor(Color.RED)
                }

                surname == 0 -> {
                    neceserlySurname.setTextColor(Color.RED)
                }

                lastname == 0 -> {
                    neceserlyLastname.setTextColor(Color.RED)
                }

                else -> {

                }
            }
        }
    }
}

    companion object {
        @JvmStatic
        fun newInstance() = PassNameAndSurnameFragment()
    }
}


