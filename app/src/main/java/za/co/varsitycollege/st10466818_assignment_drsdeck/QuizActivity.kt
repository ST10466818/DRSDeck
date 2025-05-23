package za.co.varsitycollege.st10466818_assignment_drsdeck

import android.content.Intent
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
    val questions = arrayOf(
        "Red Bull Racing's engine supplier is Ferrari.",
        "Ayrton Senna won three Formula One World Championships.",
        "The Monaco Grand Prix is the fastest track on the calendar.",
        "Lewis Hamilton has less pole positions than Michael Schumacher.",
        "DRS was only introduced in F1 in 2010."
    )

    val answers = booleanArrayOf(
        false, // Red Bull uses Honda/Porsche engines
        true,  // Senna won in 1988, 1990, 1991
        false, // Monaco is the slowest track
        false, // Hamilton has more poles than Schumacher
        true   // DRS introduced in 2010
    )
    var currentQuestionIndex = 0
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Initialize views
        val questionTextView = findViewById<TextView>(R.id.questionBox)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
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
            showNextQuestion()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun checkAnswer(userAnswer: Boolean) {
        val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        // Check answer

        if (currentQuestionIndex >= answers.size) return

        if (userAnswer == answers[currentQuestionIndex]) {
            score++
            feedbackTextView.text = "Correct!"
        } else {
            feedbackTextView.text = "Wrong!"
        }

        // Disable the true/false buttons after answering
        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }

            fun showNextQuestion() {
                currentQuestionIndex++

                if (currentQuestionIndex < questions.size) {

                    val questionTextView = findViewById<TextView>(R.id.questionBox)
                    val trueButton = findViewById<Button>(R.id.trueButton)
                    val falseButton = findViewById<Button>(R.id.falseButton)
                    val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)

                    questionTextView.text = questions[currentQuestionIndex]
                    feedbackTextView.text = ""
                    trueButton.isEnabled = true
                    falseButton.isEnabled = true // show next question
                } else {
                    // Quiz finished - here you put the code to go to results
                    val intent = Intent(this, ResultsActivity::class.java)
                    intent.putExtra("SCORE", score)   // pass the score
                    startActivity(intent)              // start results activity
                    finish()                          // finish quiz activity (optional)

        }
    }


}





