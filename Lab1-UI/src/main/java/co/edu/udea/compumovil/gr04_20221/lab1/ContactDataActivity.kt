package co.edu.udea.compumovil.gr04_20221.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.log

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        val cities = resources.getStringArray(R.array.array_español_cities)
        val cityAdapter = ArrayAdapter(this, R.layout.list_item, cities)
        val autoCity = findViewById<AutoCompleteTextView>(R.id.autoCompleteCity)
        autoCity.setAdapter(cityAdapter)
        val countries = resources.getStringArray(R.array.array_español_countries)
        val countryAdapter = ArrayAdapter(this, R.layout.list_item, countries)
        val autoCountry = findViewById<AutoCompleteTextView>(R.id.autoCompleteCountry)
        autoCountry.setAdapter(countryAdapter)
        val btnDone = findViewById<Button>(R.id.btn_next2)
        val inputPhone = findViewById<TextInputEditText>(R.id.inputTel)
        val inputAddress = findViewById<TextInputEditText>(R.id.InputAddr)
        val inputEmail = findViewById<TextInputEditText>(R.id.InputEmail)
        val fieldError = resources.getString(R.string.fieldError)

        val nameId = intent?.extras?.getString("name").toString()
        val lastNameId = intent?.extras?.getString("lastName").toString()
        val sexId = intent?.extras?.getString("sex").toString()
        val dateId = intent?.extras?.getString("bDate").toString()
        val gradeId = intent?.extras?.getString("grade").toString()

        btnDone.setOnClickListener {
            if (inputPhone.text.isNullOrBlank()) {
                inputPhone.setError(fieldError)
            } else {
                if (inputEmail.text.isNullOrBlank()) {
                    inputEmail.setError(fieldError)
                } else {
                    if (autoCountry.text.isNullOrBlank()) {
                        autoCountry.setError(fieldError)
                    } else {
                        Log.i("* Información personal *", "")
                        Log.i("Nombres", nameId)
                        Log.i("Apellidos", lastNameId)
                        Log.i("Sexo", sexId)
                        Log.i("Fecha de cumpleaños", dateId)
                        Log.i("Grado de escolaridad", gradeId)
                        Log.i("* Información de contacto *", "")
                        Log.i("Telefono", inputPhone.text.toString())
                        if (!inputAddress.text.isNullOrBlank()) {
                            Log.i("Dirección", inputAddress.text.toString())
                        }
                        Log.i("Email", inputEmail.text.toString())
                        if (!autoCountry.text.isNullOrBlank()) {
                            Log.i("Pais", autoCountry.text.toString())
                        }
                        Log.i("Ciudad", autoCity.text.toString())
                    }
                }
            }
        }

    }
}