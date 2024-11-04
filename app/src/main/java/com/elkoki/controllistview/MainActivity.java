package com.elkoki.controllistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private ListView listview1;

    private String countries [] = { "Estados Unido", "Mexico", "Canada", "Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay", "Guyana", "Surinam" };
    private String populations [] = { "329,071,000", "125,357,000", "37,346,000", "40,000,000", "17,000,000", "6,500,000", "10,000,000", "30,000,000", "14,000,000", "183,000,000", "44,000,000", "29,000,000", "3,500,000", "783,000", "571,000" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtView = findViewById(R.id.txtView);
        listview1 = findViewById(R.id.listview1);

        ArrayAdapter <String> adapter = new ArrayAdapter <String>(this, R.layout.list_item_sudamerica, countries);
        listview1.setAdapter(adapter);
        listview1.setOnItemClickListener((parent, view, position, id) -> {
            txtView.setText("La poblacion de " + countries[position] + " es de " + populations[position]);
        });
    }
}