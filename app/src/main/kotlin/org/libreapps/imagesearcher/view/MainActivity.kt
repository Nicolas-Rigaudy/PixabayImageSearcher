package org.libreapps.imagesearcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import org.libreapps.imagesearcher.R
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val searchButton = findViewById<Button>(R.id.search_button)

        searchButton.setOnClickListener {
            val text = editText.text.toString()
            search(text)
        }

        editText.setOnKeyListener(View.OnKeyListener { v , keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                val text = editText.text.toString()
                search(text)
                return@OnKeyListener true
            }
            return@OnKeyListener false
        })
    }

    private fun search (inputText : String){
        val intent = Intent(this@MainActivity, ImagesActivity::class.java)
        intent.putExtra("inputText", inputText) //Optional parameters

        this@MainActivity.startActivity(intent)
    }

}