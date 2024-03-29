/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dessertclicker

import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import timber.log.Timber


class DessertTimer(lifecycle: Lifecycle) : LifecycleObserver {


    var secondsCount = 0

    private var handler = Handler()
    private lateinit var runnable: Runnable
    init {
        lifecycle.addObserver(this)
    }






    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer() {

        runnable = Runnable {
            secondsCount++
            Timber.i("Timer is at : $secondsCount")
            // postDelayed re-adds the action to the queue of actions the Handler is cycling
            // through. The delayMillis param tells the handler to run the runnable in
            // 1 second (1000ms)
            handler.postDelayed(runnable, 1000)
        }


        handler.postDelayed(runnable, 1000)


    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer() {

        handler.removeCallbacks(runnable)
    }
}