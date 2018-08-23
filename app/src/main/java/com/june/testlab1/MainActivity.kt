package com.june.testlab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.june.testlab1.ui.Main2Activity
import kotlinx.android.synthetic.main.activity_main.*
import com.andexert.library.RippleView
import com.june.testlab1.networking.APIModule
import com.june.testlab1.networking.modelAPI.LoginRequest
import com.june.testlab1.networking.modelAPI.Nasa
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    var num1 : Int?  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnLogin.setOnClickListener{
            //Action
//            val intent = Intent(this, Main2Activity::class.java)
//            intent.putExtra("MONEY","JUNE")
//            startActivity(intent)

            var body:LoginRequest = LoginRequest("","Mobile",edtUsername.text.toString(),"password",edtPassword.text.toString())

            APIModule.connect().login(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //On Next  200 OK
                            { Log.e("Status","On Next")},
                            //On Error
                            {Log.e("Status","On Error")},
                            //On Complete
                            {Log.e("Status","On Complete")}

                    )

        }

        btnNasa.setOnClickListener{
            var body:Nasa = Nasa ("","","","","","","","")

            APIModule.connectnasa().nasa(body)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            //On Next  200 OK
                            { Log.e("Status","On Next")},
                            //On Error
                            {Log.e("Status","On Error")},
                            //On Complete
                            {Log.e("Status","On Complete")}

                    )
        }

    }



}
