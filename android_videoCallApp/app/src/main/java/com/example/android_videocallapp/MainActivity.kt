package com.example.android_videocallapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import org.jitsi.meet.sdk.JitsiMeetOngoingConferenceService
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var code : EditText
    lateinit var join : Button
    lateinit var serverUrl : URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        code = findViewById(R.id.room_code)
        join = findViewById(R.id.join)

        serverUrl = URL("https://meet.jit.si")
        var defaultOptions = JitsiMeetConferenceOptions.Builder()
            .setServerURL(serverUrl)
            .setWelcomePageEnabled(false)
            .build()
        JitsiMeet.setDefaultConferenceOptions(defaultOptions)

        join.setOnClickListener {
            var roomOptions = JitsiMeetConferenceOptions.Builder()
                .setRoom(code.getText().toString())
                .setWelcomePageEnabled(false)
                .build();
            JitsiMeetActivity.launch(this, roomOptions)
        }
    }

}