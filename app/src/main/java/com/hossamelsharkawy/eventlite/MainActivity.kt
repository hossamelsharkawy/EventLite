package com.hossamelsharkawy.eventlite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun event() {

        val event = EventN()

        event.emit()

        event.sub {

        }

        event.unSub {

        }
    }
}
