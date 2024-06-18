package com.ahbap.android.app.crapsgames

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.crapsgames.databinding.ActivityLoginBinding
import com.ahbap.android.app.crapsgames.view.ActivityLoginListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    private var mFlag = true
    private var mRand = 0
    private fun initialize() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        mBinding.user = 0
        mBinding.bot = 0
        mBinding.random = 0
        mBinding.views = ActivityLoginListener(this)
        mBinding.mbot = 0
        mBinding.muser = 0
        mBinding.mrand = "7,11"
        mBinding.check = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun crapsRandomNumbers() {
        if (!mFlag) {
            when (mBinding.random) {
                mRand -> crapsFlagTrue()
                2 -> crapsBots()
                3 -> crapsBots()
                12 -> crapsBots()

            }
        }
    }

    private fun crapsFlagTrue() {
        mBinding.user = ++mBinding.muser
        mBinding.mrand = "7,11"
        mFlag = true

    }

    private fun crapsFlagFalse() {
        mFlag = false
        mBinding.mrand = mBinding.random.toString()
        mRand = mBinding.random


    }

    private fun crapsBots() {
        mBinding.mbot += 1
        mBinding.bot = mBinding.mbot
        mBinding.mrand = "7,11"
        mFlag = true
    }

    private fun crapsControls()
    {
        if (mBinding.user == 3) {
            Toast.makeText(this@LoginActivity, "tebrikler kazandınız", Toast.LENGTH_SHORT).show()
            mBinding.muser = 0
            mBinding.user = 0
            mBinding.bot = 0
        }
        else if (mBinding.bot == 3) {
            Toast.makeText(this@LoginActivity, "kaybettiniz", Toast.LENGTH_SHORT).show()
            mBinding.mbot = 0
            mBinding.bot = 0
            mBinding.user = 0
        }
    }
    fun getButtonClicked() {
        mBinding.check = false

        object : CountDownTimer(5000, 1000) {
            override fun onTick(ms: Long) {
                GlobalScope.launch {
                    var mSecond = ms.toInt()
                    while (mSecond > 0) {
                        mBinding.random = Random.nextInt(1, 7) + Random.nextInt(1, 7)
                        Thread.sleep(500)
                        mSecond /= 1000
                    }

                }
                ms / 5000
            }

            override fun onFinish() {
                if (mFlag)
                    when (mBinding.random) {
                        7 -> crapsFlagTrue()
                        11 -> crapsFlagTrue()
                        2 -> crapsBots()
                        3 -> crapsBots()
                        12 -> crapsBots()
                        else -> crapsFlagFalse()

                    }
                else
                    crapsRandomNumbers()

                crapsControls()
                mBinding.check = true
            }
        }.start()



    }
}
