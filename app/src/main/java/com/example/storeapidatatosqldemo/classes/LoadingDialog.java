package com.example.storeapidatatosqldemo.classes;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

import com.example.storeapidatatosqldemo.R;

public class LoadingDialog {

    Context context;
    Dialog dialog;

    public LoadingDialog(Context context){

        this.context = context;
    }

    public void showLoadingDialog(String title){

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.loading_progress_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView txtTitle = dialog.findViewById(R.id.txtTitle);

        txtTitle.setText(title);
        dialog.create();
        dialog.show();
    }

    public void hideDialog(){
        dialog.dismiss();
    }

}
