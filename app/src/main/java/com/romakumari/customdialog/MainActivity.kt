package com.romakumari.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.romakumari.customdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btndelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage(" DO WANT TO DELETE THIS?")
                .setPositiveButton("yes")
                { _, _, ->
                    Toast.makeText(this, " Clicked yes", Toast.LENGTH_SHORT)
                    binding.tvName.text = "Name"
                    binding.tvRollno.text = "Rollno"
                }
                .setNegativeButton("no") { _, _, ->
                    Toast.makeText(this, " Clicked no", Toast.LENGTH_SHORT)
                }.setCancelable(false)
                .show()
        }
        binding.btnupdate.setOnClickListener {
            var dialog=Dialog(this)
            dialog.setContentView(R.layout.custom_dialog)
            var etName=dialog.findViewById<EditText>(R.id.etName)
            var etRollNo=dialog.findViewById<EditText>(R.id.etRollNo)
            var update=dialog.findViewById<Button>(R.id.btnUpdate)

            update.setOnClickListener {
               if ( etName.text.toString().isNullOrEmpty())
               {
                   etName.error="Enter Your Name"

               } else if (etRollNo.text.toString().isNullOrEmpty())
                   {
                       etRollNo.error="Enter Your Roll no."

            } else {
                binding.tvName.setText(etName.text.toString())
                   binding.tvRollno.setText(etRollNo.text.toString())
                   dialog.dismiss()
               }

               }
            dialog.show()
        }
    }
}