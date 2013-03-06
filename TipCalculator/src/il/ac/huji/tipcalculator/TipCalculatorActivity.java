package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import android.app.Activity;
import android.graphics.Color;


public class TipCalculatorActivity extends Activity {

	public static final int TIP_PERC = 12;
	public static final int ALL_PERC = 100;
	
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    
        final Button button = (Button) findViewById(R.id.btnCalculate);
        button.setText("Calculate");
        button.setTextColor(Color.GRAY);
        button.setOnClickListener(new OnClickListener() {

        	
        	public void onClick(View v) {
        		EditText bill = (EditText)findViewById(R.id.edtBillAmount);
        		double doubleBill =Double.parseDouble(bill.getText().toString());
        		
        		double tip = (doubleBill * TIP_PERC) / ALL_PERC;
        		
        		//round tip or not
        		CheckBox roundBox = (CheckBox)findViewById(R.id.chkRound);
        		boolean round = roundBox.isChecked();
        	
        		TextView res = (TextView)findViewById(R.id.txtTipResult);
        		if(round){
        			res.setText(Editable.Factory.getInstance().newEditable("Tip: $" +(int)Math.round(tip)));
        		}
        		else{
        			res.setText(Editable.Factory.getInstance().newEditable("Tip: $" + String.format("%.2f", Math.floor(tip*100)/100)));
        		}
        		
        	}
        });
        
    }
}
