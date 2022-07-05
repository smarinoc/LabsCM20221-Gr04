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
        val fieldError = resources.getString(R.string.fieldError)

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
                inputName.setError(fieldError)
            } else {
                if (inputLastName.text.isNullOrBlank()){
                    inputLastName.setError(fieldError)
                } else {
                    if(textfieldDate.text.isNullOrBlank()){
                        textfieldDate.setError(fieldError)
                    }
                    else{
                        val intent = Intent(this, ContactDataActivity::class.java)
                        val id = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
                        if(id!=null){
                            if(id.text.toString() == "Man" || id.text.toString() == "Hombre"){
                                intent.putExtra("sex", "Masculino")
                            } else{
                                intent.putExtra("sex", "Femenino")
                            }

                        }
                        intent.putExtra("bDate", textfieldDate.text.toString())
                        if(!auto.text.isNullOrBlank()){
                            intent.putExtra("grade", auto.text.toString())
                        }

                        intent.putExtra("name", inputName.text.toString())
                        intent.putExtra("lastName", inputLastName.text.toString())
                        startActivity(intent)

                    }
                }
            }
        }
    }

}