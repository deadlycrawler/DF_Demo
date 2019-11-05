package John.df_demo.RecyclerViewClasses;

//class stores the items for a single row of a list object, these are used in list view stack to show the plethora of items
public class List {

    private String mPartNumber;
    private String mCategory;
    private String mStatus;
    private String mNotes;


    //constructor
    public List(String partNumber, String category, String status, String notes) {
        mPartNumber = partNumber;
        mCategory = category;
        mStatus = status;
        mNotes = notes;
    }

    //getters
    public String getmPartNumber() {
        return mPartNumber;
    }

    public String getmCategory() {
        return mCategory;
    }

    public String getmStatus() {
        return mStatus;
    }

    public String getmNotes() {
        return mNotes;
    }

}
