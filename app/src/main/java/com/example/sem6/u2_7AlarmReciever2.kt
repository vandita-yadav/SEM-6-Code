package com.example.sem6


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.widget.Toast

class u2_7AlarmReciever2 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context, "Alarm Ringing!", Toast.LENGTH_LONG).show()

        val mediaPlayer = MediaPlayer.create(context, android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI)
        mediaPlayer.start()
    }
}