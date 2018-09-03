package com.june.testlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    var mAuth : FirebaseAuth? = null
    private val TAG:String = "Register Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth!!.currentUser != null){
            startActivity(Intent(this@RegisterActivity, ResultActivity::class.java))
            finish()
        }
        btnCreateAccount.setOnClickListener{
            val email = edtRegisterEmail.text.toString().trim {it <= ' '}
            val password = edtRegisterPassword.text.toString().trim { it <= ' '}

            if (email.isEmpty()){
                toast("Plase enter your email address.")
                Log.d(TAG,"Email was empty")
                return@setOnClickListener
            }
            if (password.isEmpty()){
                toast("Plase enter your password.")
                Log.d (TAG, "Password was empty")
                return@setOnClickListener
            }

            mAuth!!.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (password.length < 6) {
                        toast("รหัสสั้นเกินไป ต้องใส่ 6 ตัวขึ้นไป")
                        Log.d(TAG, "Enter password less than 6 characters.")
                    } else {
                        toast("Authentication Failed" + task.exception)
                        Log.d(TAG, "Authentication Failed" + task.exception)
                    }
                } else {
                    toast("Create account successfully!")
                    Log.d(TAG, "Create account successfully!")
                    startActivity(Intent(this@RegisterActivity, ResultActivity::class.java))
                }
            }
        }
        txvSignIn.setOnClickListener { startActivity(Intent(this@RegisterActivity , LoginActivity::class.java)) }
    }
}
