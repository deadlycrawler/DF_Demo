package John.df_demo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import John.df_demo.DataBaseClasses.DbHelper;
import John.df_demo.RecyclerViewClasses.List;
import John.df_demo.RecyclerViewClasses.ListAdapter;
import androidx.appcompat.app.AppCompatActivity;
import John.df_demo.DataBaseClasses.DataContract.DataEntry;

/**
 * view all activity
 */

public class ViewAllActivity extends AppCompatActivity {

    //Class Objects
    private DbHelper mDbHelper;
    final ArrayList<List> lists = new ArrayList<List>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        mDbHelper = new DbHelper(this);


        ListAdapter adapter = new ListAdapter(this, lists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }


    public void displayDatabaseInfo() {
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
            // In the while loop below, iterate through the rows of the cursor and
//            put the information into a ListItem to display
//

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(DataEntry._ID);
            int PartNumberIndex = cursor.getColumnIndex(DataEntry.COLUMN_PART_NUMBER);
            int CategoryIndex = cursor.getColumnIndex(DataEntry.COLUMN_CATEGORY);
            int Part_status = cursor.getColumnIndex(DataEntry.COLUMN_PART_STATUS);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.

                //currently unused but can be used to track or order items,
                int currentID = cursor.getInt(idColumnIndex);

                String PartNumber = cursor.getString(PartNumberIndex);
                String Category = cursor.getString(CategoryIndex);
                String status = cursor.getString(Part_status);
                String notes = "notes place holder text";

                //add items to the list view
                lists.add(new List(PartNumber, Category, status, notes));
            }
        } finally {
            // close the cursor when you're done reading with it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

}
