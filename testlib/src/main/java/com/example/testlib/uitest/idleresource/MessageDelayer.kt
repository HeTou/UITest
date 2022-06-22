package com.example.testlib.uitest.idleresource

import android.os.Handler

class MessageDelayer {

    companion object{
        private val DELAY_MILLIS = 3000
        /**
         * Takes a String and returns it after [.DELAY_MILLIS] via a [DelayerCallback].
         * @param message the String that will be returned via the callback
         * @param callback used to notify the caller asynchronously
         */
        fun processMessage(message: String?, callback: DelayerCallback?,
                           idlingResource: SimpleIdlingResource?) {
            // The IdlingResource is null in production.
            idlingResource?.setIdleState(false)

            // Delay the execution, return message via callback.
            val handler = Handler()
            handler.postDelayed({
                if (callback != null) {
                    callback.onDone(message)
                    idlingResource?.setIdleState(true)
                }
            }, DELAY_MILLIS.toLong())
        }
    }

    interface DelayerCallback {
        fun onDone(text: String?)
    }


}