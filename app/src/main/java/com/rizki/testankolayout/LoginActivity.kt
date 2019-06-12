package com.rizki.testankolayout

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginActivity : AppCompatActivity() {

    companion object {
        lateinit var et_nama : EditText
        lateinit var btn_login : Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewLogin().setContentView(this)
        btn_login.setOnClickListener {
            startActivity<MainActivity>("nama" to et_nama.text.toString())
            finish()
        }
    }

    class ViewLogin : AnkoComponent<LoginActivity>{
        override fun createView(ui: AnkoContext<LoginActivity>) = with(ui){
            verticalLayout {
                lparams {
                    //                    gravity = Gravity.CENTER
//                    centerInParent()
                    width = matchParent
                    height = matchParent
                    verticalGravity = Gravity.CENTER
                    backgroundColor = Color.parseColor("#c5cbd6")
                    padding = 50
                }
                verticalLayout {
                    lparams(matchParent, wrapContent) {
                        background = ResourcesCompat.getDrawable(resources, R.drawable.border_radius, null)
                    }
                    textView {
                        text = "HELLO"
                        textSize = 15.0f
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(matchParent, wrapContent) {
                        margin = 25
                    }
                    et_nama = editText{
                        hint = "Input your name"
                    }.lparams(matchParent, wrapContent) {
                        margin = 30
                    }
                    btn_login = button {
                        text = "GO"
                        backgroundColor = Color.CYAN
                        textColor = Color.WHITE
                    }.lparams(wrapContent, wrapContent) {
                        margin = 30
                        gravity = Gravity.CENTER_HORIZONTAL
                    }
                }
            }
        }

    }
}