package za.co.varsitycollege.st10466818_assignment_drsdeck

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        // Show first question when app starts
        binding.questionTextView.text = questions[currentQuestionIndex]

// Button click handlers
        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var questonBox =findViewById<TextView>(R.id.questionBox)
        //actual flashcard where questions will show up
        var falseButton = findViewById<Button>(R.id.falseButton)
        //Stay out means True
        var trueButtton = findViewById<Button>(R.id.trueButton)
        //Box,Box means False
        var button3 = findViewById<Button>(R.id.button3)
 
        falseButton.setOnClickListener{
            Toast.makeText(this@MainActivity2, "False", Toast.LENGTH_SHORT
            ).show()}
        trueButtton.setOnClickListener{
            Toast.makeText(this@MainActivity2, "True", Toast.LENGTH_SHORT
            ).show()}
        button3.setOnClickListener{
            Toast.makeText(this@MainActivity2, "Next Page", Toast.LENGTH_SHORT
            ).show()}
    }
    // List of questions and answers (True or False)
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

    private fun checkAnswer(userAnswer: Boolean) {
        // 5. Check answer
        if (userAnswer == answers[currentQuestionIndex]) score++ then binding.feedbackTextView.text = "Correct!" else binding.feedbackTextView.text = "Wrong!"

        // 6. Move to next question
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) then showCurrentQuestion ()
        else
        // Quiz finished
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("SCORE", score)
        MainActivity(intent)
    }
