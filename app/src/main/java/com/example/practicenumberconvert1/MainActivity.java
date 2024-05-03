package com.example.practicenumberconvert1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputString; // variable
    RadioButton bt1,bt2,bt3;
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
        inputString = findViewById(R.id.editTextNumberSigned); // присвоил значение  и строке и кнопкам
        bt1 = findViewById(R.id.radioButton7);
        bt2 = findViewById(R.id.radioButton8);
        bt3 = findViewById(R.id.radioButton9);
    }

    public void buttoOnClick(View view) {
        //создаётся в .xml вручную
        if(bt1.isActivated()){
            inputString.setText("кто прочёл, тот и осёл");
        }
    }
}