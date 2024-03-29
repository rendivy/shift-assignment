package com.example.shift_application.data.shared

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import com.example.shift_application.data.entity.CredentialsBody
import java.security.MessageDigest
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

    private fun hashString(type: String, input: String): String {
        val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
        return bytes.fold("") { str, it -> str + "%02x".format(it) }
    }


    fun isUserLoggedIn(): Boolean {
        return sharedPreferences.contains("name")
    }


    fun logout() {
        sharedPreferences.edit().remove("name").apply()
        sharedPreferences.edit().remove("surname").apply()
        sharedPreferences.edit().remove("birthDate").apply()
    }


    fun saveCredentials(name: String, surname: String, birthDate: String, password: String) {
        val hashedPassword = hashString("SHA-256", password)
        sharedPreferences.edit()
            .putString("name", name)
            .putString("surname", surname)
            .putString("birthDate", birthDate)
            .putString("password", hashedPassword)
            .apply()
    }


    fun getCredentials(): CredentialsBody {
        val name = sharedPreferences.getString("name", "") ?: ""
        val surname = sharedPreferences.getString("surname", "") ?: ""
        val birthDate = sharedPreferences.getString("birthDate", "") ?: ""
        return CredentialsBody(name, surname, birthDate)
    }
}