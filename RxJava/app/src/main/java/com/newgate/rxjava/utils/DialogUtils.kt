package com.newgate.rxjava.utils

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.newgate.rxjava.R

/**
 * Created by apple on 8/28/17.
 */
class DialogUtils {

    companion object {
        fun getInstance(): DialogUtils {
            var instance: DialogUtils? = null
            if(instance == null) {
                instance = DialogUtils()
            }
            return instance
        }
    }

    fun showAlertDialogLockBackButton(context: Context, callback: DialogListener) {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_alert_dialog, null)
        val builder = AlertDialog.Builder(context)
        builder.setView(view)
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        val okButton = view.findViewById(R.id.btn_ok) as TextView
        val noButton = view.findViewById(R.id.btn_cancel) as TextView
        okButton.setOnClickListener {
            callback.okListener()
            dialog.dismiss()
        }
        noButton.setOnClickListener {
            callback.noListener()
            dialog.dismiss()
        }
        dialog.show()
    }

    interface DialogListener {
        fun okListener()
        fun noListener()
    }
}