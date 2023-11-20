package com.example.workauth.presentation.preference

import android.content.Context
import com.example.workauth.presentation.auth.fragment.WriteNumberPhoneFragment

private const val NUMBER_PHONE_KEY = "KEY_PHONE"
private const val NAME_KEY = "KEY_NAME"
private const val SURNAME_KEY = "KEY_SURNAME"
private const val LASTNAME_KEY = "KEY_LASTNAME"

class AppPreference(ctx: Context){

    private val dataNumber = ctx.getSharedPreferences(NUMBER_PHONE_KEY, Context.MODE_PRIVATE)
    private val dataName = ctx.getSharedPreferences(NUMBER_PHONE_KEY, Context.MODE_PRIVATE)
    private val dataSurname = ctx.getSharedPreferences(NUMBER_PHONE_KEY, Context.MODE_PRIVATE)
    private val dataLastname = ctx.getSharedPreferences(NUMBER_PHONE_KEY, Context.MODE_PRIVATE)


    fun saveNumber(number: String) {
        dataNumber.edit().putString(NUMBER_PHONE_KEY, number).apply()
    }
    fun getNumber(): String {
        return dataNumber.getString(NUMBER_PHONE_KEY, "").toString()
    }


    fun saveName(name: String) {
        dataName.edit().putString(NAME_KEY, name).apply()
    }

    fun getName(): String {
        return dataName.getString(NAME_KEY, "").toString()
    }

    fun saveSurname(surname: String) {
        dataSurname.edit().putString(SURNAME_KEY, surname).apply()
    }

    fun getSurname(): String {
        return dataSurname.getString(SURNAME_KEY, "").toString()
    }

    fun saveLastname(lastname: String) {
        dataLastname.edit().putString(LASTNAME_KEY, lastname).apply()
    }

    fun getLastname(): String {
        return dataLastname.getString(LASTNAME_KEY, "").toString()
    }
}