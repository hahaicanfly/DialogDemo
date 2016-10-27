package com.example.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by akira on 2016/10/27.
 */
public class FullScreenDialog extends Dialog {

    private Context context;
    private ImageView mYesBtn, mNoBtn;

    public FullScreenDialog(Context context) {
        super(context, R.style.MyFullScreenDialog);
        setContentView(R.layout.fullscreen_dialog_layout);
        this.context = context;

        init();
    }

    private void init() {
        mYesBtn = (ImageView) findViewById(R.id.btnYes);
        mNoBtn = (ImageView) findViewById(R.id.btnNo);

        mYesBtn.setOnClickListener(listener);
        mNoBtn.setOnClickListener(listener);
    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnYes:
                    Toast.makeText(context, "Click Full Screen OK!", Toast.LENGTH_SHORT).show();
                    dismiss();

                    break;
                case R.id.btnNo:
                    Toast.makeText(context, "Click Full Screen No!", Toast.LENGTH_SHORT).show();
                    dismiss();
                    break;
            }
        }
    };


}
