package company.com.madbikes;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import company.com.madbikes.SQLHelper;

/**
 * Created by SHE on 2015/11/1.
 */
public class SignUp extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    switch(v.getId()){
        case R.id.submit:
            EditText et_phone = (EditText) findViewById(R.id.Pnumber);
            et_phone.setInputType(InputType.TYPE_CLASS_PHONE);
            EditText et_email = (EditText) findViewById(R.id.email);
            et_email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            EditText et_address = (EditText) findViewById(R.id.address);
            et_address.setInputType(InputType.TYPE_CLASS_TEXT);
            EditText et_username =(EditText) findViewById(R.id.Name);
            et_username.setInputType(InputType.TYPE_CLASS_TEXT);
            EditText et_password = (EditText) findViewById(R.id.sign_up_pass);
            et_password.setInputType(InputType.TYPE_CLASS_TEXT);

            SQLiteDatabase db = null;
            db = openOrCreateDatabase("MAD.DB", SQLiteDatabase.CREATE_IF_NECESSARY,null);


            try {
                final String CREATE_TABLE_CONTAIN ="CREATE TABLE IF NOT EXISTS USERS("
                        + "UID" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "USERNAME"+ " TEXT NOT NULL, "
                        +"ADDRESS" + "TEXT NOT NULL"
                        + "NAME "+ " TEXT NOT NULL, "
                        + "PASSWORD" + " TEXT NOT NULL," + "PHONE" + "INTEGER NOT NULL);";

                db.execSQL(CREATE_TABLE_CONTAIN);
                Toast.makeText(SignUp.this,"table created", Toast.LENGTH_LONG).show();


            String sql = "INSERT or replace INTO USERS(USERNAME, ADDRESS, NAME, PASSWORD, PHONE) VALUES('+et_username+','+et_address+',"
                    +"'+et_name+','+et_password+','+et_phone+');";
            db.execSQL(sql);
            }
            catch (Exception e){
                Toast.makeText(SignUp.this,"table not created", Toast.LENGTH_LONG).show();
            }

                Intent intent = new Intent(SignUp.this, SignIn.class);
                this.startActivity(intent);
            break;
        case R.id.cancel:
            Intent intent1 = new Intent(SignUp.this, MainActivity.class);
            this.startActivity(intent1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);



        Button submit= (Button)findViewById(R.id.submit);
        Button cancel= (Button)findViewById(R.id.cancel);
        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.mp) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}

