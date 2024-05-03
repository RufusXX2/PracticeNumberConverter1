package com.example.practicenumberconvert1;
//NumperConvert
//v1
//03.05.2024
//Arthur Belugin
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputString, outputString; // variable
    String strVal;
    private static String[] hexadecimalChart = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    // моссив тут, чтобы срздаваться рдин раз, а не каждый раз при вызове функции, я буду обращаться к нему как к const
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
        outputString = findViewById(R.id.editTextText2);
        strVal = String.valueOf(inputString.getText()); // мы из editable сделали string и его уже получили
        bt1 = findViewById(R.id.radioButton7);
        bt2 = findViewById(R.id.radioButton8);
        bt3 = findViewById(R.id.radioButton9);
        // нажмём одну из кнопок по умолчанию
        bt1.toggle();
    }

    public void buttoOnClick(View view) {
        //создаётся в .xml вручную
        strVal = String.valueOf(inputString.getText());
        char sign = ' '; //знак числа
        if(!strVal.isEmpty()){
            //если число отрицательное
            if(strVal.contains("-")){
                sign = '-';
            }
            int num = Integer.parseInt(strVal.replace(" ", "").replace("-", ""));

            //System.out.println(); // вывод на экран LogCat снизу слева(котик)
            if(bt1.isChecked()){
                outputString.setText(sign+ConvertNumber(num,2));
            }
            if(bt2.isChecked()){
                outputString.setText(sign+ConvertNumber(num,8));
            }
            if(bt3.isChecked()){
                outputString.setText(sign+ConvertNumber(num,16));
            }
        }
        else{
            outputString.setText("Введите число");
        }


    }
    String ConvertNumber(int num, int i){
        // i - это наша система счисления
        String str = "";
        //String hexadecimal [] = new String[16]; //рабочий вариант для пустого массива, но мы используем другой

        while(num > 0){
            if(i == 16)
                str = hexadecimalChart[num%i] + str;
            else
                str = (num%i+"")+ str;
            num = num/i;
        }
        return (str);
    }
}