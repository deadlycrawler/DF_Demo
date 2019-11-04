package John.df_demo.RecyclerViewClasses;

//class stores the items for a single row of a list object, these are used in list view stack to show the plethora of items
public class List {


    private String mPartNumber;
    private String mCatigory;
    private String mStatus;
    private String mNotes;


    //constructer
    public List(String partNumber, String catigory, String status, String notes) {
        mPartNumber = partNumber;
        mCatigory = catigory;
        mStatus = status;
        mNotes = notes;

    }


    //getters

    public String getmPartNumber() {
        return mPartNumber;
    }

    public String getmCatigory() {
        return mCatigory;
    }

    public String getmStatus() {
        return mStatus;
    }

    public String getmNotes() {
        return mNotes;
    }

}
