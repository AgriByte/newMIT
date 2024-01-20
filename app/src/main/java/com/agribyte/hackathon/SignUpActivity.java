package com.agribyte.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import getterSetter.GetSetSignUp;

public class SignUpActivity extends AppCompatActivity {

        FirebaseAuth mAuth = FirebaseAuth.getInstance ();
        EditText edtusername, edtupassword, edtfullname, edtphonenumber;
        TextView txtlog;
        Button btnsignup;
        RadioButton  farmer, customer;

        @Override protected void onCreate(Bundle savedInstanceState) {
            super.onCreate ( savedInstanceState );
            setContentView ( R.layout.activity_sign_up );
            edtusername = findViewById ( R.id.edtusername );
            edtupassword = findViewById ( R.id.edtpin );
            btnsignup = findViewById ( R.id.signUpBtn );
            edtfullname = findViewById ( R.id.edtfullname );
//            edtother = findViewById ( R.id.edtsporthistory );
//        edtaddress=findViewById( R.id.address );
            edtphonenumber = findViewById ( R.id.edtphoneno );
            farmer = findViewById ( R.id.radiof );
            customer = findViewById ( R.id.radioc );
            txtlog = findViewById(R.id.txtlog);
            txtlog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i3 = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(i3);
                }
            });

            btnsignup.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    String username = edtusername.getText ().toString ().trim ();
                    String password = edtupassword.getText ().toString ().trim ();
                    Signup ( username, password );
                }
            } );
        }

        public void Signup(String username, String password) {
            mAuth.createUserWithEmailAndPassword ( username, password )
                    .addOnCompleteListener ( this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if ( task.isSuccessful () ) {
// Signup successful, get user ID
                                String userId = mAuth.getCurrentUser ().getUid ();
                                Toast.makeText ( SignUpActivity.this, "UserCreated-" + userId, Toast.LENGTH_LONG ).show ();
                                GetSetSignUp user = new GetSetSignUp ();
                                user.setEdtfullname ( edtfullname.getText ().toString () );
                                user.setEdtusername ( edtusername.getText ().toString () );
                                user.setEdtphonenumber ( edtphonenumber.getText ().toString () );
                                if ( farmer.isChecked () ) {
                                    user.setFarmer ( "farmer" );
                                } else {
                                    user.setCustomer ( "customer" );
                                }


                                DatabaseReference mdatabase = FirebaseDatabase.getInstance ().getReference ();
                                mdatabase.child ( "Users" ).child ( userId ).setValue ( user );

                                Intent i = new Intent ( getApplicationContext (), BottombarActivity.class );
                                startActivity ( i );
                                finish ();
// Do something with the user ID
                            } else {
// Signup failed
                                Log.e ( "TAG", "Signup failed.", task.getException () );
                                Toast.makeText ( SignUpActivity.this, "Error-" + task.getException ().getMessage (), Toast.LENGTH_LONG ).show ();
                            }
                        }
                    } );

        }
    }

