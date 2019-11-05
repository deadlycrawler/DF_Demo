package John.df_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import John.df_demo.DataBaseClasses.DbHelper;
import androidx.appcompat.app.AppCompatActivity;

/**
 * main activity
 */


public class MainActivity extends AppCompatActivity {

    //Button list
    Button AddNewPageButton;
    Button ViewAllPageButton;
    TextView CurrentDBSize;
    private DbHelper mDbHelper;

//    incomplete feature commented out
//    Button viewCategoryButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddNewPageButton = (Button) findViewById(R.id.AddNewButton);
        ViewAllPageButton = (Button) findViewById(R.id.ViewAllButton);
        CurrentDBSize = (TextView) findViewById(R.id.DataBaseSizeTextView);

//        incomplete feature commented out
//        viewCategoryButton = (Button) findViewById(R.id.ViewCategoryButton);


        AddNewPageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AddNewView();
            }
        });


        ViewAllPageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ViewAll();
            }
        });
    }

    //starts up the AddNewActivity page
    private void AddNewView() {
        AddNewActivity Activity = new AddNewActivity();
        Intent i = new Intent(MainActivity.this, AddNewActivity.class);
        startActivity(i);

    }

    //starts up the ViewAllActivity page
    private void ViewAll() {
        Intent i = new Intent(MainActivity.this, ViewAllActivity.class);
        startActivity(i);

    }

}