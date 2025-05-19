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
}