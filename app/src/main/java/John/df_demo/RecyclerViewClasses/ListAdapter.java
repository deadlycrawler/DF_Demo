package John.df_demo.RecyclerViewClasses;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import John.df_demo.R;


public class ListAdapter extends ArrayAdapter<List> {


    public ListAdapter(Activity context, ArrayList<List> ListItems) {

        super(context, 0, ListItems);

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        final List currentItem = getItem(position);

        TextView PartPrice = (TextView) listItemView.findViewById(R.id.PartNumberTextViewListView);
        PartPrice.setText("# " + currentItem.getmPartNumber());

        TextView Category = (TextView) listItemView.findViewById(R.id.itemCatagoryTextViewListView);


        Category.setText(currentItem.getmCatigory());

        TextView Status = (TextView) listItemView.findViewById(R.id.statusTextViewListView);
        Status.setText(currentItem.getmStatus());

        return listItemView;
    }

}
