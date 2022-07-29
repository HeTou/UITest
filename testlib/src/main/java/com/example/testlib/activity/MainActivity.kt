package com.example.testlib.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.IdlingResource
import com.example.testlib.testEntity.idleresource.MessageDelayer
import com.example.testlib.R
import com.example.testlib.fragment.MainFragment
import com.example.testlib.testEntity.idleresource.SimpleIdlingResource

class MainActivity : AppCompatActivity(), MessageDelayer.DelayerCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.fragment_container, MainFragment())
        beginTransaction.commit()

    }

    fun onClick(view: View) {
        Log.d("TAG", "onClick")
        Toast.makeText(this, "111111", Toast.LENGTH_LONG).show()

        MessageDelayer.processMessage("message", this, mIdlingResource)
    }

    override fun onDone(text: String?) {
        findViewById<Button>(R.id.tv).text = text
    }

    // The Idling Resource which will be null in production.
    private var mIdlingResource: SimpleIdlingResource? = null

    /**
     * Only called from test, creates and returns a new [SimpleIdlingResource].
     */
    @VisibleForTesting
    fun getIdlingResource(): IdlingResource {
        if (mIdlingResource == null) {
            mIdlingResource = SimpleIdlingResource()
        }
        return mIdlingResource!!
    }
}