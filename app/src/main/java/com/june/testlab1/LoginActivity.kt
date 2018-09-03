package com.june.testlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login2.*
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {


    var mAuth : FirebaseAuth? = null
    private val TAG: String = "Login Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth!!.currentUser != null){
            startActivity(Intent(this@LoginActivity, ResultActivity::class.java))
            finish()
        }
        btnLogin.setOnClickListener{
            val email = edtEmail.text.toString().trim {it <= ' ' }
            val password = edtPassword.text.toString().trim { it <= ' '}

            if (email.isEmpty()){
                toast("Plase enter your email address")
                Log.d(TAG,"Email was empty")
                return@setOnClickListener
            }
            if (password.isEmpty()){
                toast( "Plase enter your Password.")
                Log.d(TAG,"Password was empty")
                return@setOnClickListener
            }

            mAuth!!.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (password.length < 6) {
                        edtPassword.error = "Plase check your password. Password must have minimum 6 characters."
                        Log.d(TAG, "Enter password less than 6 characters.")
                    } else {
                        toast("Authentication Failed." + task.exception)
                    }
                } else {
                    toast("Sign in successfully!")
                    Log.d(TAG, "Sign in successfully!")
                    startActivity(Intent(this@LoginActivity, ResultActivity::class.java))
                    finish()
                }
            }
        }
        txvCreateAccount.setOnClickListener {startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))}
    }
}
