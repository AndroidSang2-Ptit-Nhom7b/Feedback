package com.example.aipham.vietlai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinnerDanhSachFeedback;
    DatabaseReference mdata;
    static String loaiphanhoi;

    HashMap<String,Object> a = new HashMap<String, Object>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerDanhSachFeedback = (Spinner)findViewById(R.id.spinner);
        final ArrayList<NDFeedback> arrayList = new ArrayList<NDFeedback>();
        arrayList.add(new NDFeedback(R.drawable.bug, "Phát hiện lỗi"));
        arrayList.add(new NDFeedback(R.drawable.new1, "Yêu cầu tính năng mới"));
        arrayList.add(new NDFeedback(R.drawable.traslate, "Hỗ trợ phiên dịch"));
        arrayList.add(new NDFeedback(R.drawable.others, "Khác"));
        NDFeedbackAdapter ndFeedbackAdapter = new NDFeedbackAdapter(this, R.layout.noidungfeedback,arrayList);
        spinnerDanhSachFeedback.setAdapter(ndFeedbackAdapter);
        spinnerDanhSachFeedback.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, arrayList.get(position).noiDung, Toast.LENGTH_SHORT).show();
                loaiphanhoi=""+ arrayList.get(position).noiDung;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Fragment_profile fp=new Fragment_profile();

        TextView textView=(TextView)findViewById(R.id.email);
        Button btnsend=(Button)findViewById(R.id.btnsend);
        final EditText editText=(EditText)findViewById(R.id.edittxt) ;




        textView.setText(""+fp.mail);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"cham",Toast.LENGTH_SHORT).show();
                Fragment_profile fp=new Fragment_profile();

                a.put("User",""+fp.mail);
                a.put("LoaiPhanHoi",""+loaiphanhoi);
                a.put("NoiDungPhanHoi",""+editText.getText());


                Log.e("123","123 :"+a);

                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                mdata = database.getReference();

                mdata.child("Phanhoi").push().setValue(a);

            }
        });






    }

    @Override
    public void onClick(View v) {

    }
}




