package com.pktech.newapp.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential

class AuthRepository {

    private val auth = FirebaseAuth.getInstance()

    fun loginWithEmail(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                callback(it.isSuccessful, it.exception?.message)
            }
    }

    fun loginWithGoogle(idToken: String, callback: (Boolean, String?) -> Unit) {
        val credential = com.google.firebase.auth.GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener {
                callback(it.isSuccessful, it.exception?.message)
            }
    }

    fun loginWithOtp(credential: PhoneAuthCredential, callback: (Boolean, String?) -> Unit) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener {
                callback(it.isSuccessful, it.exception?.message)
            }
    }

    fun logout() = auth.signOut()
}