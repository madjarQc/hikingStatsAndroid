package madjar.hikingstats;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.joda.time.DateTime;

import madjar.hikingstats.hikingstats.Travel;


public class HikingStats extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking_stats);

        //Pop interface

        TextView t = (TextView) findViewById(R.id.textView1);
        TextView t2 = (TextView) findViewById(R.id.textView2);

        Travel tra = new Travel(new DateTime(), new DateTime());
        t.setText(Double.toString(tra.getDuration()) + " s");
        t2.setText(Double.toString(tra.getDistance()) + " m");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hiking_stats, menu);
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
