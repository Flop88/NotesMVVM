package ru.mvlikhachev.notesmvvm.utilits

import android.content.Context
import android.content.SharedPreferences

object AppPreference {

    private const val INIT_USER = "initUser"
    private const val TYPE_DATABASE = "typeDB"
    private const val NAME_PREF = "preference"

    private lateinit var mPreference: SharedPreferences

    fun getPreference(context: Context) : SharedPreferences {

        mPreference = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreference
    }

    fun setInitUser(init: Boolean) {
        mPreference.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    fun setTypeDB(type: String) {
        mPreference.edit()
            .putString(TYPE_DATABASE, type)
            .apply()
    }

    fun getInitUser():Boolean {
        return mPreference.getBoolean(INIT_USER, false)
    }

    fun getTypeDB():String {
        return mPreference.getString(TYPE_DATABASE, TYPE_ROOM).toString()
    }

}