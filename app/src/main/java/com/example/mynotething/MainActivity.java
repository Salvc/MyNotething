package com.example.mynotething;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
public class MainActivity extends AppCompatActivity {

    Sub theSub;
    EditText Name;
    EditText TODO1;
    EditText TODO2;
    EditText TODO3;
    EditText date1;
    EditText date2;
    EditText date3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.Name);
        Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    String Name = s.toString();
                    theSub.setName(Name);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        TODO1 = findViewById(R.id.TODO1);
        TODO1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    String TODO1 = s.toString();
                    theSub.setTODO1(TODO1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //Sal its me past Sal! Just copy and paste what you did for 'name' 3 more times, but don't forget to change da words
        TODO2 = findViewById(R.id.TODO2);
        TODO2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    String TODO2 = s.toString();
                    theSub.setTODO2(TODO2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        TODO3 = findViewById(R.id.TODO3);
        TODO3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    String TODO3 = s.toString();
                    theSub.setTODO3(TODO3);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        date1 = findViewById(R.id.date1);

        date1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                System.out.println("before");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("on");

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("after " + s);

                try {
                    String sDate1 = s.toString();
                    Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
                    System.out.println(sDate1 + "\t" + date1);
                    theSub.setDate1(date1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        date2 = findViewById(R.id.date2);

        date2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    String sDate2 = s.toString();
                    Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate2);
                    System.out.println(sDate2 + "\t" + date2);
                    theSub.setDate2(date2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        date3 = findViewById(R.id.date3);

        date3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    try {
                        String sDate3 = s.toString();
                        Date date3 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate3);
                        System.out.println(sDate3 + "\t" + date3);
                        theSub.setDate3(date3);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            });


        initializeSub();
    }
    @Override
    protected void onStop(){
        this.saveSub();
        System.out.println("sub saved");
        super.onStop();
    }

    private void initializeSub() {
        // try to read (deserialize) model object from disk
        File savedCheckboxSub = new File(getApplicationContext().getFilesDir(), "savedTodoList");
        if (savedCheckboxSub.exists()) {
            try {
                FileInputStream savedCheckboxSubFileStream = new FileInputStream(savedCheckboxSub);
                ObjectInputStream in = new ObjectInputStream(savedCheckboxSubFileStream);
                theSub  = (Sub)in.readObject();
                System.out.println("sub read object");

                in.close();
                System.out.println("init in closed");

                savedCheckboxSubFileStream.close();
                System.out.println("init savedCheckboxSubFileStream closed");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (theSub != null) {
            SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
            date1.setText(ft.format(theSub.getDate1()));
            date2.setText(ft.format(theSub.getDate2()));
            date3.setText(ft.format(theSub.getDate3()));
            Name.setText(theSub.getName());
            TODO1.setText(theSub.getTODO1());
            TODO2.setText(theSub.getTODO2());
            TODO3.setText(theSub.getTODO3());


        } else {
            System.out.println("there is no sub yet");
            theSub = new Sub();
        }
        // updateUI based on saved model


    }
    private void saveSub() {
        // write (serialize) the model object
        try {
            File savedSubFile = new File(getApplicationContext().getFilesDir(), "savedTodoList");
            FileOutputStream savedSubFileStream = new FileOutputStream(savedSubFile);
            ObjectOutputStream out = new ObjectOutputStream(savedSubFileStream);
            System.out.println("Sub is: " + theSub);

            out.writeObject(theSub);
            out.close();
            savedSubFileStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
