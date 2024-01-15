package com.example.my_service_broadcast_receive

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my_service_broadcast_receive.ui.theme.My_Service_Broadcast_ReceiveTheme

class MainActivity : ComponentActivity() {
//    lateinit var receiver: BroadcastReceiver
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            My_Service_Broadcast_ReceiveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }

                context = LocalContext.current

//                val filter = IntentFilter().apply {
//                    addAction(Intent.ACTION_POWER_CONNECTED)
//                    addAction(Intent.ACTION_POWER_DISCONNECTED)
//                }

//                receiver = object : BroadcastReceiver(){
//                    override fun onReceive(context: Context?, intent: Intent?) {
////                        Toast.makeText(context, intent?.action, Toast.LENGTH_LONG).show()
//                    }
//                }
//                registerReceiver(receiver, filter)

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {
                        context.let {
                            it.startService(
                                Intent(
                                    it,
                                    MyIntentService::class.java
                                ).apply {
                                    putExtra(
                                        MY_SERVICE_STRING_EXTRA,
                                        "УРА"
                                    )
                                })
                        }
                    }) {
                        Text(text = "startService")
                    }
                    Button(onClick = {

//                        sendBroadcast(Intent(context, MyBroadcastReceiver::class.java).putExtra("rfr", "КАКА"))
                        context.let {

                        }
                    }) {
                        Text(text = "sendBroadcast")
                    }
                }
            }
        }
    }

    override fun onDestroy() {
//        unregisterReceiver(receiver)
        super.onDestroy()
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

    @Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    My_Service_Broadcast_ReceiveTheme {
        Greeting("Android")
    }
}