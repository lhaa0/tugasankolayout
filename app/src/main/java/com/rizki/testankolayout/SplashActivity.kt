package com.rizki.testankolayout

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.TextView
import org.jetbrains.anko.*

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewSplash().setContentView(this)
        Handler().postDelayed({
            startActivity<LoginActivity>()
            finish()
        }, 2000)
    }

    class ViewSplash : AnkoComponent<SplashActivity> {
        override fun createView(ui: AnkoContext<SplashActivity>) = with(ui){
            verticalLayout {
                lparams{
//                    gravity = Gravity.CENTER
//                    centerInParent()
                    width = matchParent
                    height = matchParent
                    verticalGravity = Gravity.CENTER
                }
                verticalLayout {
                    lparams(matchParent, wrapContent) {
                        imageView {
                            imageResource = R.drawable.ic_face
                        }.lparams(matchParent, 250)
                        textView {
                            text = "LATIHAN ANKO LAYOUT"
                            textSize = 20.0f
                            topMargin = 25
                            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                        }.lparams(matchParent, wrapContent)
                        textView {
                            text = "versi 1.0"
                            textSize = 15.0f
                            topMargin = 15
                            textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                        }.lparams(matchParent, wrapContent)
                    }
                }
            }
        }
    }
}