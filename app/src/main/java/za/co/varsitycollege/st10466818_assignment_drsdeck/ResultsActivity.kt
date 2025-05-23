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


        val displayBox = findViewById<TextView>(R.id.displayBox)
        val reviewBox = findViewById<TextView>(R.id.reviewBox)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val textView2 = findViewById<TextView>(R.id.textView2)


        val score = intent.getIntExtra("Score", 0)
        val totalQuestions = 5

        displayBox.text = "$score/$totalQuestions"

        val message = when (score) {
            5 -> "P1 ,Okay Michael Schumacher ! Absolute dominance — you raced through like a true F1 legend. Lights out and away you GOAT!"
            4 -> "P2 on the grid! You’ve got the speed and the strategy — just one pit stop away from greatness!"
            3 -> "Podium finish! You’re making your team proud — just a few tweaks and you'll be championship material!"
            2 -> "Points awarded! 🏎️ You held your own out there — keep practicing those laps and the podium will come!"
            1 -> "Rookie debut 🍼 You’ve entered the race and that’s what counts! Legends like Senna all started somewhere ❤️"
            0 -> "Crash out on lap 1 😅 But hey — even Grosjean walked out of fire and kept smiling. Reset, refuel, and come back stronger!"
            else -> "DNF"
        }

        reviewBox.text = message

        exitButton.setOnClickListener {
            finish()
        }
    }
}












