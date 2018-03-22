package rgblabs.com.genjitsu;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ganesh S on 3/20/2018.
 */

public class culture extends AppCompatActivity {
    String pageData[];          //Stores the text to swipe.
    LayoutInflater inflater;    //Used to create individual pages
    ViewPager vp;
    Button b;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.culture);
        pageData=getResources().getStringArray(R.array.desserts);
        b = (Button) findViewById(R.id.next);
        //get an inflater to be used to create single pages
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Reference ViewPager defined in activity
        vp= findViewById(R.id.viewPager);
        //set the adapter that will create the individual pages
        vp.setAdapter(new MyPagesAdapter());
    }
    public static int c=0;
    class MyPagesAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            //Return total pages, here one for each data item
            return pageData.length;
        }
        //Create the given page (indicated by position)
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View page = inflater.inflate(R.layout.page,null);

            ((TextView)page.findViewById(R.id.textMessage)).setText(pageData[position]);
            if(position+1 == pageData.length){
                b.setVisibility(View.VISIBLE);
                b.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(culture.this,map.class);
                        startActivity(i);
                    }
                });
            }
            //Add the page to the front of the queue
            container.addView(page, 0);
            return page;
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            //See if object from instantiateItem is related to the given view
            //required by API
            return arg0== arg1;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}