package com.example.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.add ->{
                this.startActivity(Intent(this,Add_student::class.java))
                return true
            }
//            R.id.add -> Toast.makeText(this,"Add form selected",Toast.LENGTH_SHORT).show()
            R.id.bulk_add -> Toast.makeText(this,"Bulk add selected",Toast.LENGTH_SHORT).show()
            R.id.view -> Toast.makeText(this,"View option selected",Toast.LENGTH_SHORT).show()
            R.id.nav2 -> Toast.makeText(this,"Book Vaccine",Toast.LENGTH_SHORT).show()
            R.id.nav1 -> Toast.makeText(this,"Generate Report",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}