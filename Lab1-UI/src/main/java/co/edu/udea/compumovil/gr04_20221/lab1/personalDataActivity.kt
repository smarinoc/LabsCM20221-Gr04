package co.edu.udea.compumovil.gr04_20221.lab1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
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
        val btnNext = findViewById<Button>(R.id.btnNext)
        val inputName = findViewById<TextInputEditText>(R.id.inputName)
        val inputLastName = findViewById<TextInputEditText>(R.id.inputlastName)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

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
        btnNext.setOnClickListener {

            if (inputName.text.isNullOrBlank()){
                inputName.setError("")
            } else {
                if (inputLastName.text.isNullOrBlank()){
                    inputLastName.setError("")
                } else {
                    if(textfieldDate.text.isNullOrBlank()){
                        textfieldDate.setError("")
                    }
                    else{
                        Log.i("Información personal", "")
                        Log.i("Nombres", inputName.text.toString())
                        Log.i("Apellidos", inputLastName.text.toString())
                        val id = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
                        if(id!=null){
                            Log.i("Sexo", id.text.toString())
                        }
                        Log.i("Fecha de cumpleaños", textfieldDate.text.toString())
                        if(!auto.text.isNullOrBlank()){
                            Log.i("Grado de escolaridad", auto.text.toString())
                        }
                        val intent = Intent(this, ContactDataActivity::class.java)
                        intent.putExtra("name", inputName.text.toString())
                        intent.putExtra("lastName", inputLastName.text.toString())
                        startActivity(intent)

                    }
                }
            }
        }
    }

}