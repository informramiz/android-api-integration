package github.informramiz.com.androidapiintegration.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import github.informramiz.com.androidapiintegration.R
import kotlinx.android.synthetic.main.aai_toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.main_nav_host_fragment)
        toolbar.setupWithNavController(navController)
    }

}
