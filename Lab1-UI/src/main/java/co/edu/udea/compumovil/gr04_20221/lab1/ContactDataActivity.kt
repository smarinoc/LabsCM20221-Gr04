package co.edu.udea.compumovil.gr04_20221.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)

        val nameId = intent?.extras?.getString("name").toString()
        val lastNameId = intent?.extras?.getString("lastName").toString()
        Log.i("Name", nameId)
        Log.i("LastN", lastNameId)
    }
}