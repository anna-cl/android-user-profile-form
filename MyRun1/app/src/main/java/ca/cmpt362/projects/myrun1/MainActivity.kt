//MyRun1 Android App  due
//Programmer: Chaoer Liang
//Reference:
//https://stackoverflow.com/questions/15005551/androidplacing-the-radio-buttons-horizontally
//https://stackoverflow.com/questions/2550099/how-to-kill-an-android-activity-when-leaving-it-so-that-it-cannot-be-accessed-fr
//https://www.tutorialspoint.com/how-to-get-the-selected-index-of-a-radiogroup-in-android-using-kotlin
//https://www.youtube.com/watch?v=S5uLAGnBvUY&ab_channel=Indently


package ca.cmpt362.projects.myrun1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //define valuables
//    private lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

    }

    //This function is listening UI SAVE button click --> android:onClick="saveButtonClick" in xml file
    fun saveButtonClick(view: View) {

        // Text edit:
        val nameEdit: EditText = findViewById(R.id.editText_name)
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
        lateinit var selectedRadioValue: String
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val selectedRadioID: Int = radioGroup.checkedRadioButtonId
        if (selectedRadioID != -1) { //if no radio button is selected, selectedRadioID == -1
            val selectedRadio: RadioButton = findViewById(selectedRadioID)
            selectedRadioValue = selectedRadio.text.toString()
        } else {
            selectedRadioValue = null.toString()
        }
        println("------ SAVE BUTTON " + nameString + " " + emailString + " " + phoneString + " " + classString + " " + majorString + " " + selectedRadioValue)


//        majorEdit.setText(majorString + " UPDATED!!")   //it works  ----- Test only


        val fileName = "profileMyRun1"
        val setsharedPreferences: SharedPreferences =
            this.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = setsharedPreferences.edit()
        editor.apply{
            putString("name_key", nameString)
            putString("phone_key", phoneString)
        }.apply()



//        if (sharedPhoneValue.equals("defaultphone") && sharedNameValue.equals("defaultname")) {
//            nameEdit.setText("default name: ${sharedNameValue}").toString()
//            phoneEdit.setText("default id: ${sharedPhoneValue.toString()}")
//        } else {
//            nameEdit.setText(sharedNameValue).toString()
//            phoneEdit.setText(sharedPhoneValue).toString()
//        }

        println(nameEdit)

    }

    fun loadData(){
        //        ------------ get shared preferences values -------
        val getSharedPreferences: SharedPreferences = getSharedPreferences("profileMyRun1", Context.MODE_PRIVATE)
        val sharedNameValue : String? = getSharedPreferences.getString("name_key", "defaultname")
        val sharedPhoneValue : String? = getSharedPreferences.getString("phone_key", "defaultphone")

        val textView_name: TextView = findViewById(R.id.textView_name)
        val textView_phone: TextView = findViewById(R.id.textView_phone)
//        nameEdit.setText(sharedNameValue)
//        phoneEdit.setText(sharedPhoneValue)
        textView_name.text = sharedNameValue
        textView_phone.text = sharedPhoneValue

    }

    fun cancelButtonClick(view: View){
        finish()
    }


}