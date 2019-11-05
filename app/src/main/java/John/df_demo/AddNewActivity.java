package John.df_demo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import John.df_demo.DataBaseClasses.DataContract.DataEntry;
import John.df_demo.DataBaseClasses.DbHelper;
import androidx.appcompat.app.AppCompatActivity;


public class AddNewActivity extends AppCompatActivity {
    Button Submit;
    Button Cancel;
    Spinner CategorySpinner;
    String CategorySpinnerValue;
    String PartNumber;
    String StatusNotes;
    Boolean StatusValue;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        Submit = (Button) findViewById(R.id.SubmitButton);
        Cancel = (Button) findViewById(R.id.CancelButton);
        checkBox = (CheckBox) findViewById(R.id.StatusCheckbox);
        CategorySpinner = (Spinner) findViewById(R.id.CategorySpinner);


        //submitButton ActionListener
        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SubmitFunction();
            }
        });

        //CancelButton ActionListener
        Cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CancelFunction();
            }
        });

    }


    //function call to return to Main
    private void CancelFunction() {
        Toast.makeText(AddNewActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
        ReturnToMainActivity();
    }

    //called on submit click

    /**
     * reads from all input fields, verifies inputs and submits them to the database
     */
    private void SubmitFunction() {

        //retrieves values of the fields
        PartNumber = GetPartNumber();
        StatusNotes = GetNotes();
        StatusValue = GetStatus();
        CategorySpinnerValue = GetCagegoryValue();


        if (PartNumber.matches("")) {
            Toast.makeText(this, getString(R.string.FieldRequired), Toast.LENGTH_LONG).show();
            EditText PartNumberText = (EditText) findViewById(R.id.PartNumberText);
            PartNumberText.setHint(getString(R.string.FieldRequired));

            return;
        }


        //input into database and return value of the new row added
        long newRowId = insertToDataBase(PartNumber, StatusValue, CategorySpinnerValue);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, getString(R.string.invalidEntry), Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, getString(R.string.ItemSaved) + newRowId, Toast.LENGTH_SHORT).show();
        }


        //return to MainActivity
        ReturnToMainActivity();

    }

    private String GetPartNumber() {

        EditText PartNumberText = (EditText) findViewById(R.id.PartNumberText);
        String value = PartNumberText.getText().toString().trim();

        return value;
    }

    private String GetNotes() {
        EditText PartNumberText = (EditText) findViewById(R.id.NotesText);
        String value = PartNumberText.getText().toString().trim();

        return value;
    }

    private boolean GetStatus() {
        boolean value = ((CheckBox) findViewById(R.id.StatusCheckbox)).isChecked();

        return value;
    }

    //returns to main screen
    private void ReturnToMainActivity() {
        Intent i = new Intent(AddNewActivity.this, MainActivity.class);
        startActivity(i);

    }

    private String GetCagegoryValue() {
        String value = CategorySpinner.getSelectedItem().toString();
        return value;
    }


    private long insertToDataBase(String partNumber, Boolean statusValue, String CategorySpinnerValue) {


        // Create database helper
        DbHelper mDbHelper = new DbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(DataEntry.COLUMN_PART_NUMBER, partNumber);
        values.put(DataEntry.COLUMN_CATEGORY, CategorySpinnerValue);
        values.put(DataEntry.COLUMN_PART_STATUS, statusValue);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(DataEntry.TABLE_NAME, null, values);


        return newRowId;

    }

}

