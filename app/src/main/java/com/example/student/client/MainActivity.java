package com.example.student.client;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getContent(View view)
    {
        Uri uri = Uri.parse("content://com.example.student.friends_ms.ContentProviderMS");
        ContentProviderClient client = getContentResolver().acquireContentProviderClient(uri);

        try
        {
            Cursor myCursor = client.query(uri, null, null, null, null);

            myCursor.moveToFirst();
            if(!myCursor.isAfterLast())
            {
                do
                {
                    System.out.println(myCursor.getString(0) + " " + myCursor.getString(1) + " " + myCursor.getString(2));
                } while(myCursor.moveToNext());
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in getContent(): " + e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
