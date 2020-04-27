package com.namo3t.alert_dialog;
import com.namo3t.alert_dialog.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button closeButton;
        closeButton = findViewById(R.id.buttonClose);

        Button showItemButton;
        showItemButton = findViewById(R.id.btnShow);

        Button showSingleChoice;
        showSingleChoice = findViewById(R.id.btnShowSingle);

       builder = new AlertDialog.Builder(this);  //Alert Dialog
       closeButton.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v) {
               //**Alert Dialog**/
                builder.setIcon(R.drawable.warning);
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                builder.setMessage("Are you sure to leave me? ").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(getApplicationContext(),
                                        "you choose yes action for alert box",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),
                                        "you choose no action for alert box",
                                        Toast.LENGTH_SHORT).show();
                            }


                        });


                AlertDialog alert = builder.create();
                alert.setTitle("AlertDialogExample");
                alert.show();
           }
           //Alert Dialog
       });
        showItemButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                createItemDialog();
            }
        });

        showSingleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSingleChoiceDialog();
            }
        });

    }

    private void createItemDialog() {
        final String[] items = { "Marshmallow", "Lollipop", "KitKat","Jelly Bean"};
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("เลือกเวอร์ชั่นของแอนดรอยด์")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), items[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }


    //Single Choice Dialog//
    private void createSingleChoiceDialog() {
        final String[] itemsSingle = { "Marshmallow", "Lollipop", "KitKat","Jelly Bean"};
        int checkedIndex = 1;
        final String[] checkedItems = { itemsSingle[checkedIndex] };  //มีสมาชิกเพียงตัวเดียว

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("เลือกเวอร์ชั่นของแอนดรอยด์")
                .setSingleChoiceItems(itemsSingle, checkedIndex, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //อ่านรายการที่ถูกคลิกเก็บพักไว้ในอาร์เรย์ เมื่อเราเปลี่ยนไปเลือกรายการอื่น
                        //ค่าที่เก็บในอาร์เรย์ ก็จะถูกแทนที่ด้วยค่าใหม่ไปเรื่อยๆ
                        checkedItems[0] = itemsSingle[which];
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //นำค่าของรายการที่ถูกคลิกล่าสุดจากอาร์เรย์ไปใช้งาน
                        Toast.makeText(getBaseContext(), checkedItems[0], Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

}


