package John.df_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button AddNewPageButton;
    Button ViewAllPageButton;
    Button viewCatagoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddNewPageButton = (Button) findViewById(R.id.AddNewButton);
        ViewAllPageButton = (Button) findViewById(R.id.ViewAllButton);
        viewCatagoryButton = (Button) findViewById(R.id.ViewCategoryButton);


        AddNewPageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AddNewView();
            }
        });

        ViewAllPageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ViewAll();
            }
        });
    }

    private void AddNewView() {
        AddNewActivity Activity = new AddNewActivity();
        Intent i = new Intent(MainActivity.this, Activity.getClass());
        startActivity(i);

    }

    private void ViewAll() {
        Intent i = new Intent(MainActivity.this, ViewAllActivity.class);
        startActivity(i);

    }
}
