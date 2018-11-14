package mobile.privatbank24api.utils

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat

fun Intent.startWithClearTask(context: Context) {
    this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    ContextCompat.startActivity(context, this,null)
}