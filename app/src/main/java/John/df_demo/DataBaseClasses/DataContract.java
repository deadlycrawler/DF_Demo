package John.df_demo.DataBaseClasses;

import android.provider.BaseColumns;

public class DataContract {

    private DataContract() {}

    /**
     * Inner class that defines constant values for the  database table.
     * Each entry in the table represents a single item.
     */
    public static final class DataEntry implements BaseColumns {

        /** Name of database table for items */
        public final static String TABLE_NAME = "Items";

        /**
         * Unique ID number for the item (only for use in the database table).
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the Part.
         * Type: TEXT
         */
        public final static String COLUMN_PART_NUMBER ="PartNumber";

        /**
         * Category of the part
         * Type: TEXT
         */
        public final static String COLUMN_CATEGORY = "Category";

        /**
         * Status of the part
         * Type: TEXT
         */
        public final static String COLUMN_PART_STATUS = "Status";

    }
}
