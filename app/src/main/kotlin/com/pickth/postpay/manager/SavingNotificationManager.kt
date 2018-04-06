package com.pickth.postpay.manager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
import com.pickth.postpay.R
import com.pickth.postpay.view.main.MainActivity

/**
 * Created by HaEun on 2018-04-06.
 */
object SavingNotificationManager {
    // https://developer.android.com/guide/topics/ui/notifiers/notifications.html?hl=ko#CreateNotification
    fun sendingNoti(context: Context, title: String, saving: Int) {
        val resultPendingIntent = PendingIntent.getActivity(context,
                0,
                Intent(context, MainActivity::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT)

        // ui, task
        val mBuilder = NotificationCompat.Builder(context, "test").apply {
            setSmallIcon(R.drawable.ic_money)
            setAutoCancel(true)
            setTicker("tt")
            setContentTitle(title)
            setContentText(Integer.toString(saving))
            setDefaults(Notification.DEFAULT_LIGHTS or Notification.DEFAULT_SOUND)
            setContentIntent(resultPendingIntent)
            setWhen(System.currentTimeMillis())
        }

        val mNotifyMgr = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel: NotificationChannel
        val importance: Int
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            importance = NotificationManager.IMPORTANCE_HIGH
            channel = NotificationChannel("test", "name", importance)
            mNotifyMgr.createNotificationChannel(channel)
        }

        mNotifyMgr.notify(1, mBuilder.build())
    }
}