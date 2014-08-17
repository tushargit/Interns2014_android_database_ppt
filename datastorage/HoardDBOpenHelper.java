package com.example.databasecreate;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HoardDBOpenHelper extends Activity implements OnClickListener {
	//Create objects of EditText,Button and SQLite database 
	EditText e1,e2,e3,e4,e5;
	SQLiteDatabase db;			//SQLiteDatabase has methods to create, delete, execute SQL commands, and 
								//	perform other common database management tasks. 
	Button b1;
@Override
public void onCreate(Bundle savedInstanceState) {//Called when the activity is starting. 
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
   /* Open a new private SQLiteDatabase associated with this Context's application package. 
   Create the database file if it doesn't exist.*/
    
    db = openOrCreateDatabase( "data.db" , SQLiteDatabase.CREATE_IF_NECESSARY  , null   );
    try {
        final String CREATE_TABLE_CONTAIN = "CREATE TABLE IF NOT EXISTS Emp ("
                          
                + "AMOUNT TEXT,"
                + "TRNS TEXT," + "isdefault TEXT);";
        db.execSQL(CREATE_TABLE_CONTAIN);
        Toast.makeText(HoardDBOpenHelper.this, "table created ", Toast.LENGTH_LONG).show();
        
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);
       // String sql =
         //   "INSERT or replace INTO tbl_Contain (DESCRIPTION, expirydate, AMOUNT, TRNS,isdefault) VALUES('this is','03/04/2005','5000','tran','y')" ;       
         //       db.execSQL(sql);
    }
    catch (Exception e) {
       Toast.makeText(HoardDBOpenHelper.this, "ERROR "+e.toString(), Toast.LENGTH_LONG).show();  
}}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch(v.getId())
	{
	case R.id.button1:

		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		//e4=(EditText)findViewById(R.id.editText4);
		//e5=(EditText)findViewById(R.id.editText5);
		System.out.println("Helloooo");
		String myEditText1=e1.getText().toString();
		String myEditText2=e2.getText().toString();
		String myEditText3=e3.getText().toString();
	//	String myEditText4=e4.getText().toString();
	//	String myEditText5=e5.getText().toString();
		//e5.setText(myEditText1);
		//SQLiteDatabase db;
		String sql =
	            "INSERT  INTO Emp (AMOUNT, TRNS,isdefault) VALUES('"+myEditText1+"','"+myEditText2+"','"+myEditText3+"')" ;       
	             db.execSQL(sql);
	
	             Toast.makeText(HoardDBOpenHelper.this, "Value Inserted ", Toast.LENGTH_LONG).show();
}
}}