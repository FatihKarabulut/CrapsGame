package com.ahbap.android.app.crapsgames

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ahbap.android.app.crapsgames.databinding.ActivityRegisterBinding
import com.ahbap.android.app.crapsgames.view.ActivityMainListener
import com.ahbap.android.app.crapsgames.view.ActivityRegisterListener
import com.ahbap.android.app.dataservicelib.DataserviceHalper
import com.ahbap.android.app.dataservicelib.Entity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class Register : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding

    @Inject
    lateinit var dataServices : DataserviceHalper
    private fun initialize()
    {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        mBinding.views = ActivityRegisterListener(this)
        mBinding.entity = Entity()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     initialize()
    }

    private fun alertPass()
    {
        AlertDialog.Builder(this)
            .setTitle(R.string.alert_dialog_title)
            .setMessage(R.string.alert_dialog_pass_message)
            .setNeutralButton(R.string.alert_dialog_neaturalbutton) {_,_-> }
            .create().show()
    }
    private fun alertuserInfo()
    {
        AlertDialog.Builder(this)
            .setTitle(R.string.alert_dialog_title)
            .setMessage(R.string.alert_dialog_blank_message)
            .setNeutralButton(R.string.alert_dialog_neaturalbutton) {_,_-> }
            .create().show()
    }

    fun registerGetButtonClicked()
    {
        if (mBinding.entity!!.password != mBinding.entity!!.confirmedPassword)
            alertPass()
        else if (mBinding.entity!!.name.isBlank() || mBinding.entity!!.nickName.isBlank() || mBinding.entity!!.password.isBlank())
            alertuserInfo()

        else {
        runBlocking {
            val user = Entity(0,mBinding.entity!!.name,mBinding.entity!!.nickName,mBinding.entity!!.password,mBinding.entity!!.confirmedPassword)
            GlobalScope.launch {
                if (dataServices.insert(user)) {
                    runOnUiThread{ Toast.makeText(this@Register, "Kayıt Edildi", Toast.LENGTH_SHORT).show()}
                    val shared = getSharedPreferences("user", MODE_PRIVATE).edit()
                    shared.putString("nickname", mBinding.entity!!.nickName)
                    shared.apply()

                }
                else
                    runOnUiThread{  Toast.makeText(this@Register, "Kayıt Edilemedi", Toast.LENGTH_SHORT).show()}
            }.join()
        }
        finish()
    }


    }


}