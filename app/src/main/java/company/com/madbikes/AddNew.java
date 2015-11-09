package company.com.madbikes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class AddNew extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new);
        Button submit=(Button)findViewById(R.id.submit);
        Button cancel=(Button)findViewById(R.id.cancel);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((OnItemSelectedListener) this);
        List<String> categories = new ArrayList<String>();
        categories.add("< 1 year old");
        categories.add("< 2 years old");
        categories.add("> 2 years old");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);





        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position,long id){

        String item = parent.getItemAtPosition(position).toString();

    }


    public void onClick(View v){
        switch(v.getId()){
        case R.id.submit:
            EditText bikename = (EditText) findViewById(R.id.bikename);
           // EditText address = (EditText) findViewById(R.id.address);
            //Spinner condition = (Spinner) findViewById(R.id);

            EditText price = (EditText) findViewById(R.id.new_price);
            String bikename1 = bikename.getText().toString().trim();
            //String address1 = address.getText().toString().trim();
           // String condition1 = condition.getText().toString().trim();
            String price1 = price.getText().toString().trim();
           // if(!bikename1.equals("")&&!condition1.equals("")&&!price1.equals("")){
                 startActivity(new Intent(AddNew.this, ManageProfile.class));}
           // else{
             //    Toast.makeText(getApplicationContext(), "Not enough information", Toast.LENGTH_LONG).show();
            //}
       // break;
       // case R.id.cancel:
        //startActivity(new Intent(AddNew.this, ManageProfile.class));
        //break;
       // }
    }



}
