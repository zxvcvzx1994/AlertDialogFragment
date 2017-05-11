package com.example.kh.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kh on 5/10/2017.
 */

public class Fragment_AlertDialog extends DialogFragment {
    String[] a;
    StringBuilder string;
    ArrayList<String> arrayList  =new ArrayList<String>();
    boolean[] selected;
    StringBuffer s1 ;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder  = new AlertDialog.Builder(getActivity());
        builder.setTitle("Error");
        a  = getResources().getStringArray(R.array.array);
        builder.setMultiChoiceItems(R.array.array, selected, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                s1= new StringBuffer();
                if(!a[which].equals("Select All")) {
                    if (isChecked) {
                        arrayList.add(a[which]);
                    } else
                        arrayList.remove(a[which]);
                    for(String s: arrayList) {
                        s1.append(s + "\n");
                    }
                }
                else{
                    ListView list  = ((AlertDialog) dialog).getListView();
                    for(int   i  =  0 ; i<a.length; i++){
                        list.setItemChecked(i, isChecked);
                    }
                    if(isChecked==true)
                   for(int i =  0 ; i< a.length-1; i++) {
                       s1.append(a[i] + "\n");
                   }else{
                        s1 = new StringBuffer();
                    }
                    }
                Toast.makeText(getActivity(), s1.toString(), Toast.LENGTH_SHORT).show();
                }





        });

//        builder.setItems(R.array.array, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(), a[which], Toast.LENGTH_SHORT).show();
//            }
//        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               Toast.makeText(getActivity(), s1.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "b", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog= builder.create();
        return dialog;
    }
}
