package com.kyuwankim.android.properties;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    EditText name, email, password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();


        sharedpreferences = getSharedPreferences("settigns", MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePref("name", name.getText().toString());
                savePref("email", email.getText().toString());
                savePref("password", password.getText().toString());
            }
        });


    }

    private void init() {
        name = (EditText) findViewById(R.id.editText);
        email = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);
        btn = (Button) findViewById(R.id.button);
    }

    // 저장해둔 설정값 가져오기
    private void loadPreference() {
        String name = sharedpreferences.getString("name", "[none]");
        String email = sharedpreferences.getString("email", "[none]");
        String password = sharedpreferences.getString("password", "[none]");

        this.name.setText(name);
        this.email.setText(email);
        this.password.setText(password);

    }

    // 프리퍼런스 저장
    public void savePref(String key, String value) {
        // 1. editor 꺼내기
        SharedPreferences.Editor editor = sharedpreferences.edit();

        // 2. editor 통해서 키 값을 저장
        editor.putString(key, value);

        // 3. editor 커밋
        editor.commit();

    }
}
