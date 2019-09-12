package net.bifio.batik.utils

import android.content.Context
import android.preference.PreferenceManager

class SharedPrefManager {
    companion object {
        fun setPref(context: Context, name: String, value: String) {
            val pref = PreferenceManager.getDefaultSharedPreferences(context).edit()
            pref.putString(name, value)
            pref.apply()
        }

        fun getPref(context: Context, name: String): String? {
            val pref = PreferenceManager.getDefaultSharedPreferences(context)
            return pref.getString(name, null)
        }
    }
}