package com2x3b4p.example.volleyball;

import android.content.Context;

/**
 * Created by heqianzhen on 2018/3/12.
 */

public class Alertdialog_h {
    public static android.support.v7.app.AlertDialog.Builder alertDialog(Context context, String
            title, String message, boolean cancle){
        android.support.v7.app.AlertDialog.Builder dialog=new android.support.v7.app.AlertDialog.Builder(context);
        dialog.setTitle(title)
                .setMessage(message)
                .setCancelable(cancle);
        return dialog;
    }
}
