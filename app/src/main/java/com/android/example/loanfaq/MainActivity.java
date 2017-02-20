package com.android.example.loanfaq;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] a,aa,aaa;
    ArrayList<FaqRow> arrayList;
    FaqRow faqRow;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        a = getResources().getStringArray(R.array.home1);
        aa = getResources().getStringArray(R.array.home2);
        aaa = getResources().getStringArray(R.array.home3);

        arrayList = new ArrayList<FaqRow>();
        myAdapter = new MyAdapter();

        for (int i=0;i<a.length;i++)
        {
            faqRow = new FaqRow();
            faqRow.setA(a[i]);
            faqRow.setAa(aa[i]);
            faqRow.setAaa(aaa[i]);
            arrayList.add(faqRow);
        }

        listView.setAdapter(myAdapter);
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            faqRow = arrayList.get(position);
            LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_item, parent, false);
            TextView tx_id = (TextView) convertView.findViewById(R.id.home11);
            TextView tx_questions = (TextView) convertView.findViewById(R.id.home22);
            TextView tx_answers = (TextView) convertView.findViewById(R.id.home33);

            tx_id.setText(faqRow.getA()+".");
            tx_questions.setText(faqRow.getAa());
            tx_answers.setText(faqRow.getAaa());

            return convertView;
        }
    }
}
