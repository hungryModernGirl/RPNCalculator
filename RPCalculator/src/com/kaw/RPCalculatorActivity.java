package com.kaw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RPCalculatorActivity extends Activity {
    /** Called when the activity is first created. */
  	EditText solution;
  	EditText toCalculate;
  	static Double x;
	int [] specBtn = {R.id.clear, R.id.saveX, R.id.equals, R.id.space};
	int [] btnArray = {R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5, R.id.num6, R.id.num7, R.id.num8, R.id.num9, R.id.num0, R.id.plus, R.id.minus, R.id.multiply, R.id.divide,
			R.id.Sin, R.id.Cos, R.id.Tan, R.id.sqrt, R.id.x, R.id.decimal};
	
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        solution = (EditText) findViewById(R.id.Solution);
        toCalculate = (EditText) findViewById(R.id.ToCalculate);
        x = 0.0;
        
        for (int i : btnArray){
        	final Button btn = (Button) findViewById(i);
            btn.setOnClickListener(new OnClickListener() {
                public void onClick(View v){
                  toCalculate.append(btn.getText().toString());
                }         
              });
        }

        for (int i : specBtn){
        	final Button btn = (Button) findViewById(i);
            btn.setOnClickListener(new OnClickListener() {
                public void onClick(View v){
                  if(btn.getText().equals("=")){
                	  Double solved = Calculate.solve(toCalculate.getText().toString());
                	  solution.setText(Double.toString(solved));
                  } 
                  else if (btn.getText().equals("c")){
                	  toCalculate.setText("");
                  } 
                  else if (btn.getText().equals("space")){
                	  toCalculate.append(" ");
                  }
                  else {
                	  x = (Double)Double.valueOf(solution.toString());
                  }
                }         
              });
        }
    }
    
    
    
    
}