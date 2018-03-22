package rgblabs.com.genjitsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Ganesh S on 3/20/2018.
 */

public class character extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character);

        ImageButton b = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton b1 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton b2 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton b3 = (ImageButton) findViewById(R.id.imageButton4);
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(character.this,culture.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(character.this,culture.class);
                startActivity(i);
            }
        });b2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(character.this,culture.class);
                startActivity(i);
            }
        });b3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i = new Intent(character.this,culture.class);
                startActivity(i);
            }
        });

    }
}
