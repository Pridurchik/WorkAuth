package com.example.workauth.presentation.auth.fragment

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
import com.example.workauth.databinding.FragmentWriteNumberPhoneBinding
import com.example.workauth.presentation.preference.AppPreference

private const val LIMIT_MAX_LENGTH = 18

class WriteNumberPhoneFragment : Fragment() {

    private var _binding: FragmentWriteNumberPhoneBinding? = null
    private val binding: FragmentWriteNumberPhoneBinding get() = _binding!!

    private var _preference: AppPreference? = null
    private val preference: AppPreference get() = _preference!!

    private lateinit var slideInRight: Animation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        _binding = FragmentWriteNumberPhoneBinding.inflate(inflater, container, false)
        _preference = AppPreference(requireContext())
        val view = binding.root

        setUp()

        return view
    }

    private fun setUp() = with(binding) {

        inputNumberPhoneTextInputID.addTextChangedListener(object : TextWatcher {
            private var isFormatting = false
            private var deletingHyphen = false
            private var hyphenStart = 0
            private var deletingBackward = false

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if (isFormatting) return
                if (count > 0 && s[start] == '-') {
                    deletingHyphen = true
                    hyphenStart = start
                } else {
                    deletingHyphen = false
                }
                deletingBackward = count > 0 && after == 0
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (isFormatting) return
                if (deletingHyphen && before == 1 && count == 0) {
                    isFormatting = true
                    inputNumberPhoneTextInputID.text?.delete(hyphenStart, hyphenStart + 1)
                    isFormatting = false
                }
                if (deletingBackward) {
                    isFormatting = true
                    if (before == 3 && count == 2) {
                        inputNumberPhoneTextInputID.text?.delete(start - 1, start + 1)
                    } else if (before == 2 && count == 1) {
                        inputNumberPhoneTextInputID.text?.delete(start, start + 1)
                    }
                    isFormatting = false
                }
            }

            override fun afterTextChanged(s: Editable) {

                if (inputNumberPhoneTextInputID.text?.length == LIMIT_MAX_LENGTH){
                    enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_action))
                } else {
                    enterButton.setBackgroundDrawable(resources.getDrawable(R.drawable.shapes_default))
                }

                if (isFormatting) return
                isFormatting = true

                val phone = s.toString().replace("\\D".toRegex(), "")

                // Add formatting characters
                val formattedPhone = StringBuilder()
                for (i in phone.indices) {
                    if (i == 0) {
                        formattedPhone.append("+")
                    } else if (i == 1) {
                        formattedPhone.append(" (")
                    } else if (i == 4) {
                        formattedPhone.append(") ")
                    } else if (i == 7 || i == 9) {
                        formattedPhone.append("-")
                    }
                    formattedPhone.append(phone[i])
                }
                inputNumberPhoneTextInputID.setText(formattedPhone.toString())
                inputNumberPhoneTextInputID.setSelection(formattedPhone.length)
                isFormatting = false
            }
        })

        enterButton.setOnClickListener {
            val numberText = inputNumberPhoneTextInputID.text.toString()
            val fragmentManager = parentFragmentManager
            var fragmentTransaction = fragmentManager.beginTransaction()
            val fragment = PassNumberSmsFragment.newInstance()

            if (numberText.length == LIMIT_MAX_LENGTH){
                preference.saveNumber(numberText)

                fragmentTransaction.setCustomAnimations(R.anim.slide_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.slide_out)

                fragmentTransaction
                    .replace(R.id.container_ViewID, fragment)
                    .addToBackStack(null)

                fragmentTransaction.commit()


            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = WriteNumberPhoneFragment()
    }
}