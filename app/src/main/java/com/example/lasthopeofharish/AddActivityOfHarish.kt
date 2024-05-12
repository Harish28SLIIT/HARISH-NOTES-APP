package com.example.lasthopeofharish

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lasthopeofharish.databinding.ActivityAddOfHarishBinding

class AddActivityOfHarish : AppCompatActivity() {

    private lateinit var binding: ActivityAddOfHarishBinding
    private lateinit var db: NotesDatabaseHelperOfHarish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOfHarishBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        db = NotesDatabaseHelperOfHarish(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contextEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}