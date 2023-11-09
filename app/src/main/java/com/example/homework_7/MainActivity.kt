package com.example.homework_7

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import com.example.homework_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            addField()
        }
    }

    private fun addField() {
        val newInputField = EditText(this)

        //setting the properties for new input field
        newInputField.apply {
            this.layoutParams = binding.inputField.layoutParams
            this.setTextColor(binding.inputField.textColors)
            this.setHintTextColor(binding.inputField.hintTextColors)
            this.hint = binding.inputField.text
            //default measuring units are pixels so i had to convert them in dp
            val paddingDp = (20 * Resources.getSystem().displayMetrics.density).toInt()
            this.setPadding(paddingDp, paddingDp, paddingDp, paddingDp)
        }
        //checking if the checkbox is checked
        if (binding.checkBox.isChecked) {
            newInputField.inputType = InputType.TYPE_CLASS_NUMBER
        }
        //adding the new input field to the container
        binding.container.addView(newInputField)
    }
}