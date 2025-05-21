package za.co.varsitycollege.st10466818_assignment_drsdeck

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    //Declaring Question and Answer arrays
    private val questions = arrayOf(
        "Red Bull Racing's engine supplier is Ferrari.",
        "Ayrton Senna won three Formula One World Championships.",
        "The Monaco Grand Prix is the fastest track on the calendar.",
        "Lewis Hamilton has less pole positions than Michael Schumacher.",
        "DRS was only introduced in F1 in 2010."
    )

    private val answers = booleanArrayOf(
        false, // Red Bull uses Honda/Porsche engines
        true,  // Senna won in 1988, 1990, 1991
        false, // Monaco is the slowest track
        false, // Hamilton has more poles than Schumacher
        true   // DRS introduced in 2010
    )
    private var currentQuestionIndex = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        // Initialize views
        val questionTextView = findViewById<TextView>(R.id.questionBox)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val feedbackTextView  = findViewById<TextView>(R.id.feedbackTextView)
        val button3 = findViewById<Button>(R.id.button3)

        // Show first question when app starts
        questionTextView.text = questions[currentQuestionIndex]
        // Button click handlers
        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }
        button3.setOnClickListener {
            Toast.makeText(this@QuizActivity, "Next Page", Toast.LENGTH_SHORT).show()
            // You can add logic to navigate to the next page here
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        // Check answer
        if (userAnswer == answers[currentQuestionIndex]) {
            score++
            findViewById<TextView>(R.id.feedbackTextView).text = "Correct!"
        } else {
            findViewById<TextView>(R.id.feedbackTextView).text = "Wrong!"
        }
        // Move to next question
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            findViewById<TextView>(R.id.questionBox).text = questions[currentQuestionIndex]
        } else {
            // Quiz finished
            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("SCORE", score)

            startActivity(intent)
            finish() // Optional: finish this activity if you don't want to return to it
        }
    }
}

