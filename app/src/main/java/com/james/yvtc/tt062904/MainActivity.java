package com.james.yvtc.tt062904;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Spinner spinner, spinner2, spinner3;
    TextView tv, tv2 ;
    ArrayList<String> mylist;
    ArrayList<HashMap<String, String>> list2;
    EditText ed ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        spinner3= (Spinner) findViewById(R.id.spinner3);
        ed = (EditText) findViewById(R.id.editText) ;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                TextView tv = (TextView) view;
//                String str = tv.getText().toString();
//                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                String cityArray[] = getResources().getStringArray(R.array.city);
                Toast.makeText(MainActivity.this, cityArray[position], Toast.LENGTH_SHORT).show();
                tv.setText(cityArray[position]);
             }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        String[] arr2 = {"蘋果", "香蕉", "鳳梨", "芭樂"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, arr2);
        mylist = new ArrayList<String>();
        mylist.add("蘋果");
        mylist.add( "香蕉");
        mylist.add("鳳梨");
        mylist.add("芭樂");
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,mylist);
        spinner2.setAdapter(adapter);

        list2 = new ArrayList<>();
        HashMap<String, String> m1 = new HashMap<>();
        m1.put("city", "台北");
        m1.put("code", "02");
        HashMap<String, String> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        HashMap<String, String> m3 = new HashMap<>();
        m3.put("city", "高雄");
        m3.put("code", "07");

        list2.add(m1);
        list2.add(m2);
        list2.add(m3);

        SimpleAdapter adapter2 = new SimpleAdapter(MainActivity.this, list2, android.R.layout.simple_list_item_2,
                new String[] {"city", "code"}, new int[] {android.R.id.text1, android.R.id.text2});
        spinner3.setAdapter(adapter2);
    }
    public void clickAdd(View v)
    {
        mylist.add(ed.getText().toString());
    }

    public void click1(View v){
        int sel = spinner.getSelectedItemPosition();
        String cityArray[] = getResources().getStringArray(R.array.city);
        tv2.setText(cityArray[sel]);

    }
}
