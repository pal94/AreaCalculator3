package com.example.areacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText length1;
    private EditText length2;
    private ImageView im_triangle;
    private ImageView im_square;
    private ImageView im_circle;

    private TextView tv_shapeName;
    private TextView tv_result;
    String shape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        length1 = findViewById(R.id.ed_length1);
        length2 = findViewById(R.id.ed_length2);

        tv_shapeName = findViewById(R.id.tv_shapeName);
        tv_result=findViewById(R.id.tv_result);

        im_triangle = findViewById(R.id.iv_triangle);
        im_square = findViewById(R.id.iv_square);
        im_circle = findViewById(R.id.iv_circle);

        im_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_shapeName.setText("Triangle");
                shape="Triangle";
                length1.setVisibility(View.VISIBLE);
                length2.setVisibility(View.VISIBLE);
            }
        });

        im_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_shapeName.setText("Square");
                shape="Square";
                length2.setVisibility(View.GONE);
            }
        });

        im_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_shapeName.setText("Circle");
                shape="Circle";
                length2.setVisibility(View.GONE);
            }
        });

    }

public void calculateArea(View view)
{
    float area;
    float side1;
    float side2;
    side1=0;
    side2=0;
    //String name = tv_shapeName.getText().toString();
    side1 = Float.parseFloat(length1.getText().toString());
    if(length1.getText().toString().equals(""))
    {
        length1.setError("Please Enter a number");
    }
    if(length2.getText().toString().equals(""))
    {
        length2.setError("Please Enter length");
    }

    switch(shape)
    {
        case "Triangle":
            side2 = Float.parseFloat(length2.getText().toString());
            area = (float)0.5*(side1)*(side2);
            tv_result.setText(area+"");
        case "Square":
            area = (side1)*(side1);
            tv_result.setText(area+"");
            Log.d("TAG", "Hi");
        case "Circle":
            area = (float)3.1416*(side1)*(side1);
            tv_result.setText(area+"");

    }
}

    public void clearView(View view){
        length1.setVisibility(View.VISIBLE);
        length2.setVisibility(View.VISIBLE);
        tv_shapeName.setText("Select the Shape");
        tv_result.setText("");
        length1.setText("");
        length2.setText("");
        shape="none";

    }
}
