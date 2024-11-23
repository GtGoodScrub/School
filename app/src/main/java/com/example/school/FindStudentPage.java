package com.example.school;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindStudentPage extends AppCompatActivity
implements AdapterView.OnItemSelectedListener {
    Spinner spClasses, spStudents;
    Button btnGoBack;

    String[] divisions = {"Class 5", "Class 19", "Class 22", "Class 10", "Class 15", "Class 30", "Class 25"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_student_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spClasses = findViewById(R.id.spClasses);
        spStudents = findViewById(R.id.spEval);
        btnGoBack = findViewById(R.id.btnGoBack);

        btnGoBack.setOnClickListener(view -> {
            Intent intent = new Intent(FindStudentPage.this, HomePage.class);
            startActivity(intent);
        });

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter classes = new ArrayAdapter(this,android.R.layout.simple_spinner_item, divisions);
        classes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spClasses.setAdapter(classes);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),divisions[i], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}