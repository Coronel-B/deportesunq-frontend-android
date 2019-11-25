package org.itdevelopers.deportesunq.ui.competitions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.itdevelopers.deportesunq.R

class CompetitionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.competitions_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CompetitionsFragment.newInstance())
                .commitNow()
        }
    }
}
