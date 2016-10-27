package com.example.dialogdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btnDialog,btnFullDialog;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        init();
    }


    private void init(){
        btnDialog = (Button) findViewById(R.id.dialog);
        btnFullDialog = (Button) findViewById(R.id.full_dialog);
        btnDialog.setOnClickListener(listener);
        btnFullDialog.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.dialog:
                    showDialog();
                    break;

                case R.id.full_dialog:
                    new FullScreenDialog(context).show();
                    break;
            }
        }
    };

    public void showDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Dialog Title");
        builder.setMessage("This is a Dialog!!");
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,"Click OK!",Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,"Click No!",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

}
