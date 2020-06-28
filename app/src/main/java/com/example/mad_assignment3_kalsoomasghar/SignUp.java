package com.example.mad_assignment3_kalsoomasghar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    TextView clickableText;
    Button b;
    TextInputLayout name,email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        makeTextColorfulAndClickable();

        b=(Button)findViewById(R.id.signupbutton);
        name=(TextInputLayout) findViewById(R.id.nameedit);

        email=(TextInputLayout) findViewById(R.id.emailedit);
        password=(TextInputLayout) findViewById(R.id.passwordedit);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               confirmInput(v);


               Intent i=new Intent(getApplicationContext(),RecyclerViewActivity.class);
               startActivity(i);
            }

        }
        );



    }

    public void makeTextColorfulAndClickable() {
        clickableText = findViewById(R.id.clickabletext);
        String text = "have an account? Sign in";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(SignUp.this, "Sign Up", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), SignIn.class);
                startActivity(i);

            }

            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);

                ds.setColor(getResources().getColor(R.color.blue));
                ds.setUnderlineText(false);

            }
        };

        ss.setSpan(clickableSpan1, 17, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        clickableText.setText(ss);
        clickableText.setMovementMethod(LinkMovementMethod.getInstance());

    }

  public void confirmInput(View v) {
        if (!validateEmail() | !validatePassword() | !validateName()) {
            Toast.makeText(this, "Invavlid", Toast.LENGTH_SHORT).show();
            return;
        }
        String input = "Email: " + email.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + password.getEditText().getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }

    private boolean validateEmail() {
        String emailInput = email.getEditText().getText().toString().trim();
        if (emailInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email address");

            return false;
        } else {
            email.setError(null);
            return true;

        }
    }

    private boolean validatePassword() {
        String passwordInput = password.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if(passwordInput.length()>10)
        {
            password.setError("Too Long");
            return false;
        }

        else{
            password.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String nameInput = name.getEditText().getText().toString().trim();
        if (nameInput.isEmpty()) {
            name.setError("Field can't be empty");
            return false;
        }
        else
            {
            password.setError(null);
            return true;
        }
    }



}

