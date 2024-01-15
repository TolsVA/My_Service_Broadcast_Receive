package com.example.my_service_broadcast_receive

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.Message
import android.util.Log
import android.widget.Toast

const val MY_SERVICE_STRING_EXTRA = "MyServiceStringExtra"
const val FILTER_EXTRA = "FILTER_EXTRA"

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        if (intent == null) {
//            onEmptyIntent()
        } else {
            val filter = intent.getStringExtra(FILTER_EXTRA)
//            loadMovies(filter)
        }
        Toast.makeText(applicationContext, intent?.getStringExtra(MY_SERVICE_STRING_EXTRA), Toast.LENGTH_LONG).show()
        createLogMessage("onHandleIntent ${intent?.getStringExtra(MY_SERVICE_STRING_EXTRA)}")
    }

    override fun onCreate() {
        createLogMessage("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createLogMessage("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        createLogMessage("onDestroy")
        super.onDestroy()
    }

    private  fun createLogMessage(message: String){
        Log.d("MyLog", message)
    }
}