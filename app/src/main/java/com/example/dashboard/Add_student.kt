package com.example.dashboard

import androidx.appcompat.app.AppCompatActivity

import android.widget.Button
import android.widget.EditText

import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Add_student : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var editTextClass: EditText
    lateinit var editTextContact: EditText
    lateinit var editTextDOB: EditText
    lateinit var buttonsave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

//        buttonsave = findViewById(R.id.buttonsave)
//
//        var database = FirebaseDatabase.getInstance().reference
//        //database.setValue("Hi Madhu")
//        editTextName = findViewById(R.id.editTextTextName)
//        editTextClass = findViewById(R.id.editTextTextClass)
//        editTextContact = findViewById(R.id.editTextTextContact)
//        editTextDOB = findViewById(R.id.editTextTextDOB)
//
//        buttonsave.setOnClickListener {
////                saveDetail()
//            var stu_name = editTextName.text.toString()
//            var stu_class = editTextClass.text.toString().toInt()
//            var stu_contact = editTextContact.text.toString().toInt()
//            var stu_DOB = editTextDOB.text.toString()
//            database.setValue(Student(stu_name, stu_class, stu_contact, stu_DOB))
//
//        }
//
//    }
//}

        buttonsave= findViewById(R.id.buttonsave)

        var database = FirebaseDatabase.getInstance().reference
        //database.setValue("Hi Madhu")
        editTextName =findViewById(R.id.editTextTextName)
        editTextClass =findViewById(R.id.editTextTextClass)
        editTextContact =findViewById(R.id.editTextTextContact)
        editTextDOB =findViewById(R.id.editTextTextDOB)

        buttonsave.setOnClickListener {
            saveDetail()
//            var stu_name = editTextName.text.toString()
//            var stu_class = editTextClass.text.toString().toInt()
//             var stu_contact = editTextContact.text.toString().toInt()
//             var stu_DOB = editTextDOB.text.toString()
//            database.setValue(Student(stu_name,stu_class,stu_contact,stu_DOB))

        }

    }
    private fun saveDetail()
    {
        var stu_name =editTextName.text.toString()

        var stu_class = editTextClass.text.toString().toInt()
        var stu_contact = editTextContact.text.toString().toInt()
        var stu_DOB = editTextDOB.text.toString()

        if(stu_name.isEmpty())
        {
            editTextName.error =" Please enter a name"
            return
        }
        var database = FirebaseDatabase.getInstance().getReference("Student")
        var stu_id = database.push().key
        var student = stu_id?.let { Student(it,stu_name,stu_class,stu_contact,stu_DOB) }
        if (stu_id != null) {
            database.child(stu_id).setValue(student).addOnCompleteListener {
                Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}






