package John.df_demo.RecyclerViewClasses;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import John.df_demo.R;

/**
 * list Adapter class modifies the origional list class and allows me to put more than one item per row
 * here i wanted to have 3 text views share a line.
 */
public class ListAdapter extends ArrayAdapter<List> {


    public ListAdapter(Activity context, ArrayList<List> ListItems) {

        super(context, 0, ListItems);

    }

    //retrieves the listView layout and orginizes data inputs
    public View getView(int position, View convertView, ViewGroup parent) {

        //gets the view layout
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        final List currentItem = getItem(position);

        //retries the part number box and puts in the number for the item line
        TextView PartPrice = (TextView) listItemView.findViewById(R.id.PartNumberTextViewListView);
        PartPrice.setText("# " + currentItem.getmPartNumber());

        //gets the category
        TextView Category = (TextView) listItemView.findViewById(R.id.itemCatagoryTextViewListView);
        Category.setText(currentItem.getmCategory());

        //gets the status
        TextView Status = (TextView) listItemView.findViewById(R.id.statusTextViewListView);
        Status.setText(currentItem.getmStatus());

        return listItemView;
    }

}
