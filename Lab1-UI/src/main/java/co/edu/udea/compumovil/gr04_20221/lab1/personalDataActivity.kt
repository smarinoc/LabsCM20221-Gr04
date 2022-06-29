package co.edu.udea.compumovil.gr04_20221.lab1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity



class personalDataActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_data_activity)
        val items = listOf("Material", "Design", "Components", "Android")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        val auto = findViewById<AutoCompleteTextView>(R.id.autoComplete)
        auto.setAdapter(adapter)

    }
}