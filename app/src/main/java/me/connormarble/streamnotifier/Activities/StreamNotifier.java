package me.connormarble.streamnotifier.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import me.connormarble.streamnotifier.Data.NotificationFilter;
import me.connormarble.streamnotifier.R;
import me.connormarble.streamnotifier.Utils.FileHelper;


public class StreamNotifier extends ActionBarActivity implements View.OnClickListener {

    Button addFilterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(me.connormarble.streamnotifier.R.layout.activity_main);
        addFilterBtn = (Button)findViewById(R.id.addFilter);
        addFilterBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(me.connormarble.streamnotifier.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == me.connormarble.streamnotifier.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, CreateFilter.class);

        startActivity(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();

        NotificationFilter[] filters = FileHelper.getSavedFilters(getApplicationContext());
        if(filters!=null) {
            for (NotificationFilter filter : filters) {
                Log.d("filter", "\n"+filter.toString());
            }
        }
    }
}
