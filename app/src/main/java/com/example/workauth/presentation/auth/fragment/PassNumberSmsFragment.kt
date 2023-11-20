package com.example.workauth.presentation.auth.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.workauth.R
import com.example.workauth.databinding.FragmentPassNumberSmsBinding
import com.example.workauth.presentation.preference.AppPreference


class PassNumberSmsFragment : Fragment() {


    private var _binding: FragmentPassNumberSmsBinding? = null
    private val binding: FragmentPassNumberSmsBinding get() = _binding!!

    private var _preference: AppPreference? = null
    private val preference: AppPreference get() = _preference!!




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View?
    {
        _binding = FragmentPassNumberSmsBinding.inflate(inflater, container, false)
        _preference = AppPreference(requireContext())

        setUp()
        return binding.root

    }

    private fun setUp() = with(binding) {
        binding.textInputEditText1.requestFocus()
        val imm : InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        val text = SpannableString(binding.textSmsSendID.text.toString() + preference.getNumber())
        val sb = SpannableStringBuilder(text)
        val color = resources.getColor(R.color.action_color_but)
        val color2 = resources.getColor(R.color.default_text_color)
        val fcs: ForegroundColorSpan? = ForegroundColorSpan(color)
        val fcs2: ForegroundColorSpan? = ForegroundColorSpan(color2)
        sb.setSpan(fcs2, 0, text.indexOf('+'), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sb.setSpan(fcs, text.indexOf('+'), sb.lastIndex + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.textSmsSendID.text = sb




         val fragmentManager = parentFragmentManager
         var fragmentTransaction = fragmentManager.beginTransaction()
         val fragment = PassNameAndSurnameFragment.newInstance()

        textInputEditText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val str = s.toString()

                if (str.length == 1){
                    if (textInputEditText1.length() == 1 &&
                        textInputEditText2.length() == 1 &&
                        textInputEditText3.length() == 1 &&
                        textInputEditText4.length() == 1)
                    {
                        customAnimationInNextFragment()
                    }
                    else {
                        textInputEditText2.requestFocus()
                    }

                }
            }

        })

        textInputEditText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val str = s.toString()

                if (str.length == 1){
                    if (textInputEditText1.length() == 1 &&
                        textInputEditText2.length() == 1 &&
                        textInputEditText3.length() == 1 &&
                        textInputEditText4.length() == 1)
                    {
                        customAnimationInNextFragment()
                    } else {
                        textInputEditText3.requestFocus()
                    }
                }
            }

        })

        textInputEditText3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val str = s.toString()

                if (str.length == 1){
                    if (textInputEditText1.length() == 1 &&
                        textInputEditText2.length() == 1 &&
                        textInputEditText3.length() == 1 &&
                        textInputEditText4.length() == 1)
                    {
                        customAnimationInNextFragment()
                    } else {
                        textInputEditText4.requestFocus()
                    }
                }
            }

        })

        textInputEditText4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val str = s.toString()

                if (str.length == 1){
                    if (textInputEditText1.length() == 1 &&
                        textInputEditText2.length() == 1 &&
                        textInputEditText3.length() == 1 &&
                        textInputEditText4.length() == 1)
                    {
                        customAnimationInNextFragment()

                    } else {
                    }
                }
            }

        })

        textInputEditText2.setOnKeyListener { v, keyCode, event ->
            if (textInputEditText2.text.toString().isEmpty() && keyCode == KeyEvent.KEYCODE_DEL) {

                textInputEditText1.requestFocus()

            }
            false
        }

        textInputEditText3.setOnKeyListener { v, keyCode, event ->
            if (textInputEditText3.text.toString().isEmpty() && keyCode == KeyEvent.KEYCODE_DEL) {

                textInputEditText2.requestFocus()

            }
            false
        }

        textInputEditText4.setOnKeyListener { v, keyCode, event ->
            if (textInputEditText4.text.toString().isEmpty() && keyCode == KeyEvent.KEYCODE_DEL) {
                textInputEditText3.requestFocus()
            }
            false
        }

        comeBackButtonID.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = PassNumberSmsFragment()

    }

    private fun customAnimationInNextFragment(){

        val fragmentManager = parentFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = PassNameAndSurnameFragment.newInstance()

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


