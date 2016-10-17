package com.example.espino.dinamictable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * @author Andrés Espino López
 * Exercise to learn how to create components at runtime
 * Resources used:
 * -layoutParams
 * -String arrays
 * -Shape
 * -Colors
 * */

public class DinamicTable_Activity extends AppCompatActivity {

    private TableLayout tableHeader, tableBody;
    private TableRow.LayoutParams tbrLayoutId;
    private TableRow.LayoutParams tbrLayoutName;
    private TableRow.LayoutParams tbrLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_table_);

        tableBody = (TableLayout) findViewById(R.id.tableBody);
        tableHeader = (TableLayout) findViewById(R.id.TableHeader);

        tbrLayoutId = new TableRow.LayoutParams(130, TableRow.LayoutParams.WRAP_CONTENT);
        tbrLayoutId.setMargins(0,10,0,10);
        tbrLayoutName = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT);
        tbrLayoutName.setMargins(0,10,0,10);

        tbrLayout = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);

        createHeader();
        createBody();
    }

    private void createHeader(){
        TableRow tbrHeader = new TableRow(this);
        tbrHeader.setLayoutParams(tbrLayout);

        TextView txvId = new TextView(this);
        txvId.setText(R.string.txvId);
        txvId.setLayoutParams(tbrLayoutId);
        txvId.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvId);

        TextView txvName = new TextView(this);
        txvName.setText(R.string.txvName);
        txvName.setLayoutParams(tbrLayoutName);
        txvName.setBackgroundResource(R.drawable.shape_header);
        tbrHeader.addView(txvName);

        tableHeader.addView(tbrHeader);
    }

    private void createBody(){

        TableRow tbrBody;
        TextView txvId;
        TextView txvName;

        String[] listName = getResources().getStringArray(R.array.listName);

        for(int i=0; i<listName.length;i++){
            tbrBody = new TableRow(this);
            txvId = new TextView(this);
            txvId.setText(" " + (i + 1) + " ");
            txvId.setLayoutParams(tbrLayoutId);
            txvId.setBackgroundResource(R.drawable.shape_background);

            txvName = new TextView(this);
            txvName.setText(listName[i]);
            txvName.setLayoutParams(tbrLayoutName);
            txvName.setBackgroundResource(R.drawable.shape_background);

            tbrBody.addView(txvId);
            tbrBody.addView(txvName);

            tableBody.addView(tbrBody);
            tbrBody.setLayoutParams(tbrLayout);
        }

    }
}
