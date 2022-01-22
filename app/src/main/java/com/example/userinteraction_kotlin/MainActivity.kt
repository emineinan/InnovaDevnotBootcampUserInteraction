package com.example.userinteraction_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.userinteraction_kotlin.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToastMessage.setOnClickListener {
            Toast.makeText(applicationContext, "Hello", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSnackBar.setOnClickListener {
            val snackBar = Snackbar.make(it, "Do you want to delete?", Snackbar.LENGTH_LONG)
            snackBar.setAction("YES") {
                Snackbar.make(it, "Deleted!", Snackbar.LENGTH_SHORT).show()
            }
            snackBar.setActionTextColor(Color.RED)
            snackBar.setTextColor(Color.BLUE)
            snackBar.setBackgroundTint(Color.WHITE)
            snackBar.show()
        }

        binding.buttonAlertView.setOnClickListener {
            val alertDialogView = AlertDialog.Builder(this)
            alertDialogView.setTitle("Deletion Operation")
            alertDialogView.setMessage("Do you want to delete?")
            alertDialogView.setPositiveButton("OK") { s, l ->
                Log.e("AlertDialog", "Deleted!")
            }

            alertDialogView.setNegativeButton("CANCEL") { s, l ->
                Log.e("AlertDialog", "Canceled!")
            }

            alertDialogView.create().show()
        }
    }
}