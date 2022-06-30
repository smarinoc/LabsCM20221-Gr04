package co.edu.udea.compumovil.gr04_20221.lab1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText


class personalDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personal_data_activity)
        val items = resources.getStringArray(R.array.array_español_school_grade)
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        val auto = findViewById<AutoCompleteTextView>(R.id.autoComplete)
        auto.setAdapter(adapter)
        val textfieldDate = findViewById<TextInputEditText>(R.id.editDataOfBirth)
        val btnChangeDate = findViewById<Button>(R.id.btnDateOfbirth)

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

        btnChangeDate.setOnClickListener {
            datePicker.show(supportFragmentManager, "tag");
            datePicker.addOnPositiveButtonClickListener {
                textfieldDate.setText(datePicker.headerText)
            }
        }



    }
}