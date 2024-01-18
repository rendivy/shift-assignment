package com.example.shift_application.data.shared

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import com.example.shift_application.data.entity.CredentialsBody
import javax.inject.Singleton


@Singleton
class CredentialsStorage(context: Context) {

    private val sharedPreferences = EncryptedSharedPreferences.create(
        "credentials",
        "credentials",
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )


    fun isUserLoggedIn(): Boolean {
        return sharedPreferences.contains("name")
    }


    fun logout() {
        sharedPreferences.edit().remove("name").apply()
        sharedPreferences.edit().remove("surname").apply()
        sharedPreferences.edit().remove("birthDate").apply()
    }


    fun saveCredentials(name: String, surname: String, birthDate: String) {
        sharedPreferences.edit()
            .putString("name", name)
            .putString("surname", surname)
            .putString("birthDate", birthDate)
            .apply()
    }


    fun getCredentials(): CredentialsBody {
        val name = sharedPreferences.getString("name", "") ?: ""
        val surname = sharedPreferences.getString("surname", "") ?: ""
        val birthDate = sharedPreferences.getString("birthDate", "") ?: ""
        return CredentialsBody(name, surname, birthDate)
    }
}