package com.buntoy.wallet.toast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.buntoy.wallet.toastview.ToastView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //纯文本
        //ToastView.getBuilder().showToast(this,resources.getString(R.string.app_name))

        //更改文本样式
        //ToastView.getBuilder().showToast(this, resources.getString(R.string.app_name),resources.getColor(R.color.text_green2),11)

        //带有图标
        //ToastView.getBuilder().showToast(this,resources.getString(R.string.app_name),resources.getDrawable(R.mipmap.landing_icon))

        ToastView.getBuilder().showToast(this,resources.getString(R.string.app_name),resources.getColor(R.color.text_green2),11,
                resources.getDrawable(R.mipmap.landing_icon),R.drawable.background_toast_shape)
    }
}
