package com.example.memoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MemoActivity extends AppCompatActivity {
    private Memo currentMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo1);

        initListButton();
        initSaveButton();
        initTextChangedEvents();
        // initPriority();

        currentMemo = new Memo();
    }

    private void initListButton() {

        Button listButton = (Button) findViewById(R.id.button3);
        listButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MemoActivity.this, /* This should be the new class that contains the list of memos class*/ MemoListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initTextChangedEvents() {
        final EditText newMemo = (EditText) findViewById(R.id.editText);
        newMemo.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                currentMemo.setMemoNotes(newMemo.getText().toString());
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                //  Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //  Auto-generated method stub
            }
        });

    }

    /*   private void initPriority() {
           RadioGroup rgPriority = (RadioGroup) findViewById(R.id.radioGroupSortBy);
           rgPriority.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

               @Override
               public void onCheckedChanged(RadioGroup arg0, int arg1) {
                   RadioButton rbLow = (RadioButton) findViewById(R.id.low);
                   RadioButton rbMedium = (RadioButton) findViewById(R.id.medium);
                   RadioButton rbHigh = (RadioButton) findViewById(R.id.high);
                   if (rbLow.isChecked()) {
                       getSharedPreferences("MemoPriority", Context.MODE_PRIVATE).edit() .putString("sortfield", "low").commit();
                   }
                   else if (rbMedium.isChecked()) {
                       getSharedPreferences("MemoPriority", Context.MODE_PRIVATE).edit().putString("sortfield", "medium").commit();
                   }
                   else {
                       getSharedPreferences("MemoPriority", Context.MODE_PRIVATE).edit().putString("sortfield", "high").commit();
                   }
               }
           });
       }
   */
    private void initSaveButton() {
        Button saveButton = (Button) findViewById(R.id.button2);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //  hideKeyboard();
              /*  boolean wasSuccessful = false;
                ContactDataSource ds = new ContactDataSource(ContactActivity.this);
                try {
                    ds.open();

                    if (currentContact.getContactID() == -1) {
                        wasSuccessful = ds.insertContact(currentContact);
                        int newId = ds.getLastContactId();
                        currentContact.setContactID(newId);
                    } else {
                        wasSuccessful = ds.updateContact(currentContact);
                    }
                    ds.close();
                }
                catch (Exception e) {
                    wasSuccessful = false;
                }

                if (wasSuccessful) {
                    ToggleButton editToggle = (ToggleButton) findViewById(R.id.toggleButtonEdit);
                    editToggle.toggle();
                    setForEditing(false);
                }  */
            }
        });
    }
}
