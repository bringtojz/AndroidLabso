package com.june.testlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class Mainmenu : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    private val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mAuth = FirebaseAuth.getInstance()

        if (mAuth!!.currentUser != null){
            Log.d(TAG , "Continue With" + mAuth!!.currentUser!!.email)
            startActivity(Intent(this, ResultActivity::class.java))
            finish()

        }
        btnLoginWithEmail.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
    }
    // ...
}
}
