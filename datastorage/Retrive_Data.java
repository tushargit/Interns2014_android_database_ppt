package com.example.retrivedata_database;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Retrive_Data extends Activity implements OnClickListener
{
    //declaring object of SQLiteDatabase
    SQLiteDatabase db;
    //TextView t1,t2,t3;
    EditText e1,e2,e3;
    Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       // t1=(TextView)findViewById(R.id.textView1);
        //t2=(TextView)findViewById(R.id.textView2);
        //t3=(TextView)findViewById(R.id.textView3);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);
         
        try{
            //opening database ( here database is "StudentDB" )
            db=openOrCreateDatabase("StudentDB",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        }catch(SQLException e)
        {
            Log.d("Error","Error while Opening Database");
            e.printStackTrace();
        }
    } 
        //defining cursor and select all rows from table named "student"
        

    @Override
    protected void onStop() {
       
        //closing database. its recommended.
        db.close();
        super.onStop();
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==b1)
		{
		Cursor c=db.rawQuery("SELECT * FROM student",null);
	
        try
        {
            //put cursor on the first position
            c.moveToFirst();

            //fetching all records from cursor until reaching last record
            while(!c.isAfterLast())
            {
                /*
                 * Display record on the screen
                 * Note : here in the cursor there are two columns.
                 * So be careful while fetching record.
                 * If no column is there, it will give you exception
                 */
                Toast.makeText(Retrive_Data.this,c.getString(0)+ " "+c.getString(1),1000).show();
               e1.setText(c.getString(0));
               e2.setText(c.getString(1));
               e3.setText(c.getString(2));
                //moving cursor to next record
           	c.moveToNext();
            }
            //closing cursor
            c.close();
        }catch(Exception e)
        {
            Log.d("Error","error in cursor");
            e.printStackTrace();
        }
       
		}
	}
}