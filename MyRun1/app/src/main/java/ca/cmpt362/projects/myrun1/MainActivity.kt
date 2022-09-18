//MyRun1 Android App  due
//Programmer: Chaoer Liang
//Reference:
//https://stackoverflow.com/questions/15005551/androidplacing-the-radio-buttons-horizontally
//https://stackoverflow.com/questions/2550099/how-to-kill-an-android-activity-when-leaving-it-so-that-it-cannot-be-accessed-fr
//https://www.tutorialspoint.com/how-to-get-the-selected-index-of-a-radiogroup-in-android-using-kotlin
//https://www.youtube.com/watch?v=S5uLAGnBvUY&ab_channel=Indently
//https://github.com/sandipapps/RadioSave/blob/master/app/src/main/java/com/sandipbhattacharya/radiosave/MainActivity.java


package ca.cmpt362.projects.myrun1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    //This function is listening UI SAVE button click --> android:onClick="saveButtonClick" in xml file
    fun saveButtonClick(view: View) {

        // Text edit:
        val nameEdit:EditText = findViewById(R.id.editText_name)  //------ Testing
        val nameString = nameEdit.text.toString()
        val emailEdit: EditText = findViewById(R.id.editText_email)
        val emailString = emailEdit.text.toString()
        val phoneEdit: EditText = findViewById(R.id.editText_phone)
        val phoneString = phoneEdit.text.toString()
        val classEdit: EditText = findViewById(R.id.editText_class)
        val classString = classEdit.text.toString()
        val majorEdit: EditText = findViewById(R.id.editText_major)
        val majorString = majorEdit.text.toString()

        // Radio buttons:
        lateinit var selectedRadioString: String
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val selectedRadioID: Int = radioGroup.checkedRadioButtonId
        if (selectedRadioID != -1) { //if no radio button is selected, selectedRadioID == -1
            val selectedRadio: RadioButton = findViewById(selectedRadioID)
            selectedRadioString = selectedRadio.text.toString()
        } else {
            selectedRadioString = null.toString()
        }

        //Save data to file:
        val fileName = "profileMyRun1"
        val setsharedPreferences: SharedPreferences = this.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = setsharedPreferences.edit()
        editor.apply{
            putString("name_key", nameString)
            putString("email_key", emailString)
            putString("phone_key", phoneString)
            putString("class_key", classString)
            putString("major_key", majorString)
            putString("radiobtn_key", selectedRadioString)
        }.apply()

        finish()
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
    }


    //get shared preferences values
    private fun loadData(){
        val getSharedPreferences: SharedPreferences = getSharedPreferences("profileMyRun1", Context.MODE_PRIVATE)
        val sharedNameValue : String? = getSharedPreferences.getString("name_key", null)
        val sharedEmailValue : String? = getSharedPreferences.getString("email_key", null)
        val sharedPhoneValue : String? = getSharedPreferences.getString("phone_key", null)
        val sharedClassValue : String? = getSharedPreferences.getString("class_key", null)
        val sharedMajorValue : String? = getSharedPreferences.getString("major_key", null)
        val sharedRadioButton: String? = getSharedPreferences.getString("radiobtn_key", null)

        val nameEdit:EditText = findViewById(R.id.editText_name)
        nameEdit.setText(sharedNameValue)
        val emailEdit: EditText = findViewById(R.id.editText_email)
        emailEdit.setText(sharedEmailValue)
        val phoneEdit: EditText = findViewById(R.id.editText_phone)
        phoneEdit.setText(sharedPhoneValue)
        val classEdit: EditText = findViewById(R.id.editText_class)
        classEdit.setText(sharedClassValue)
        val majorEdit: EditText = findViewById(R.id.editText_major)
        majorEdit.setText(sharedMajorValue)

        if (sharedRadioButton.equals("Female")){
            val radioButton: RadioButton = findViewById(R.id.radio_female)
            radioButton.setChecked(true)
        }else if(sharedRadioButton.equals("Male")){
            val radioButton: RadioButton = findViewById(R.id.radio_male)
            radioButton.setChecked(true)
        }
    }

    fun cancelButtonClick(view: View){
        finish()
    }

}