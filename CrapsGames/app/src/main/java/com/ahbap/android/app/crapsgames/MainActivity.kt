package com.ahbap.android.app.crapsgames

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.crapsgames.databinding.ActivityMainBinding
import com.ahbap.android.app.crapsgames.view.ActivityMainListener
import com.ahbap.android.app.crapsgames.view.user.UserInfo
import com.ahbap.android.app.dataservicelib.DataserviceHalper
import com.ahbap.android.app.dataservicelib.Entity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    @Inject
    lateinit var dataservice : DataserviceHalper
    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.views = ActivityMainListener(this)
        val shared = getSharedPreferences("user", MODE_PRIVATE)
        mBinding.user = UserInfo(shared.getString("nickname","").toString())

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()

    }

        fun registerButtonClicked()
        {
            Toast.makeText(this, "geldi", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        @OptIn(DelicateCoroutinesApi::class)
        fun loginButtonClicked()
        {

            runBlocking {
                GlobalScope.launch {
                    try {
                        if (dataservice.ExistsByNickNameAndPassword(mBinding.user!!.nickname,mBinding.user!!.pass))
                            Intent(this@MainActivity,LoginActivity::class.java).apply {startActivity(this)}
                        else
                            runOnUiThread { Toast.makeText(this@MainActivity, "hatalı Giriş", Toast.LENGTH_SHORT).show()}
                    }
                    catch (ex : IllegalArgumentException) {
                        runOnUiThread {
                            Toast.makeText(
                                this@MainActivity,
                                "Illegal Argumennt Exception",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    catch (_: Throwable)
                    {
                        runOnUiThread { Toast.makeText(this@MainActivity, "Throwable Exception", Toast.LENGTH_SHORT).show() }
                    }

                }.join()
            }
        }
}