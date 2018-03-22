package rgblabs.com.genjitsu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ganesh S on 3/21/2018.
 */

public class places extends Activity implements View.OnClickListener{
    private static final int CAMERA_REQUEST = 1888;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        b1.setOnClickListener((View.OnClickListener) this);
        b2.setOnClickListener((View.OnClickListener) this);
        b3.setOnClickListener((View.OnClickListener) this);
        b4.setOnClickListener((View.OnClickListener) this);
        b5.setOnClickListener((View.OnClickListener) this);
        b6.setOnClickListener((View.OnClickListener) this);
        b7.setOnClickListener((View.OnClickListener) this);

    }@Override
    public void onClick(View v) {
        Intent i = new Intent(places.this,camera.class);
        startActivity(i);
    }
}
