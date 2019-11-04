package John.df_demo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import John.df_demo.DataBaseClasses.DbHelper;
import John.df_demo.RecyclerViewClasses.List;
import John.df_demo.RecyclerViewClasses.ListAdapter;
import androidx.appcompat.app.AppCompatActivity;
import John.df_demo.DataBaseClasses.DataContract.DataEntry;

public class ViewAllActivity extends AppCompatActivity {
    private DbHelper mDbHelper;
    final ArrayList<List> lists = new ArrayList<List>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        mDbHelper = new DbHelper(this);



//        String PartNumber = "2468";
//        String Category = "computers";
//        String status = "good";
//        String notes = "17 is awesome";
//
//        //TODO: replace placeholders once database is in place
//
//        lists.add(new List(PartNumber, "plumbing", status, notes));
//        lists.add(new List(PartNumber, Category, status, notes));

        ListAdapter adapter = new ListAdapter(this, lists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DataEntry._ID,
                DataEntry.COLUMN_PART_NUMBER,
                DataEntry.COLUMN_CATEGORY,
                DataEntry.COLUMN_PART_STATUS};

        // Perform a query on the pets table
        Cursor cursor = db.query(
                DataEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

//        TextView displayView = (TextView) findViewById(R.id.text_view_pet);

        try {
            // Create a header in the Text View that looks like this:
            //
            // The pets table contains <number of rows in Cursor> pets.
            // _id - name - breed - gender - weight
            //
            // In the while loop below, iterate through the rows of the cursor and display
            // the information from each column in this order.
//            displayView.setText("The table contains " + cursor.getCount() + " Items.\n\n");
//            displayView.append(DataEntry._ID + " - " +
//                    DataEntry.COLUMN_PART_NUMBER + " - " +
//                    DataEntry.COLUMN_CATEGORY + " - " +
//                    DataEntry.COLUMN_PART_STATUS + " - " +"\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(DataEntry._ID);
            int PartNumberIndex = cursor.getColumnIndex(DataEntry.COLUMN_PART_NUMBER);
            int CategoryIndex = cursor.getColumnIndex(DataEntry.COLUMN_CATEGORY);
            int Part_status = cursor.getColumnIndex(DataEntry.COLUMN_PART_STATUS);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String PartNumber = cursor.getString(PartNumberIndex);
                String Category = cursor.getString(CategoryIndex);
                String status = cursor.getString(Part_status);
                String notes = "notes place holder text";



                lists.add(new List(PartNumber, Category, status, notes));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

}
