package za.co.varsitycollege.st10466818_assignment_drsdeck

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class `ResultsActivity` : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)


    }

    // 4. Review button setup
    findViewById<Button>(R.id.reviewButton).setOnClickListener {
        val reviewIntent = Intent(this, ReviewActivity::class.java)
        startActivity(reviewIntent)
    }

    // 5. Exit button
    findViewById<Button>(R.id.exitButton).setOnClickListener {
        finishAffinity() // Close all activities
    }







