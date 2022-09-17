//MyRun1 Android App  due
//Programmer: Chaoer Liang
//Reference:
//https://stackoverflow.com/questions/15005551/androidplacing-the-radio-buttons-horizontally
//https://stackoverflow.com/questions/2550099/how-to-kill-an-android-activity-when-leaving-it-so-that-it-cannot-be-accessed-fr

package ca.cmpt362.projects.myrun1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //This function is listening UI SAVE button click --> android:onClick="saveButtonClick" in xml file
    fun saveButtonClick(view: View) {

        // Text edit:
        val nameEdit: EditText = findViewById(R.id.editText_name)
        val nameString = nameEdit.text.toString()
        val emailEdit:EditText = findViewById(R.id.editText_email)
        val emailString = emailEdit.text.toString()
        val phoneEdit:EditText = findViewById(R.id.editText_phone)
        val phoneString = phoneEdit.text.toString()
        val classEdit:EditText = findViewById(R.id.editText_class)
        val classString = classEdit.text.toString()
        val majorEdit: EditText = findViewById(R.id.editText_major)
        val majorString = majorEdit.text.toString()

        // Radio buttons:
        lateinit var selectedRadioValue:String
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val selectedRadioID: Int = radioGroup.checkedRadioButtonId
        if (selectedRadioID != -1) { //if no radio button is selected, selectedRadioID == -1
            val selectedRadio:RadioButton = findViewById(selectedRadioID)
            selectedRadioValue = selectedRadio.text.toString()
        }else {
            selectedRadioValue = null.toString()
        }
        println("------ SAVE BUTTON " + nameString + " " + emailString + " " + phoneString + " " + classString + " " + majorString + " " +  selectedRadioValue)

    }


    fun cancelButtonClick(view: View){
        finish()
    }


}