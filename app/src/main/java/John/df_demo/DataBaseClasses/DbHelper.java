package John.df_demo.DataBaseClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import John.df_demo.DataBaseClasses.DataContract.DataEntry;

public class DbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DbHelper.class.getSimpleName();

    // Name of the database file
    private static final String DATABASE_NAME = "ItemDataBase.db";

    //Database version. If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    //creates database instance
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //todo: fix the inputs
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_DATA_ITEMS_TABLE =  "CREATE TABLE " + DataEntry.TABLE_NAME + " ("
                + DataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataEntry.COLUMN_PART_NUMBER + " TEXT, "
                + DataEntry.COLUMN_CATEGORY + " TEXT, "
                + DataEntry.COLUMN_PART_STATUS + " TEXT);";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_DATA_ITEMS_TABLE);

    }

    //onUpgrade is called when the database needs to be updated
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
