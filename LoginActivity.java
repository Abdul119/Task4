package com.example.abdulali.careerkey;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abdul Ali on 05/12/2016.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //Defining views
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    String url = "http://192.168.43.164/foip/login.php";
    AlertDialog.Builder builder;
    //boolean variable to check user is logged in or not
    //initially it is false
   // private boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        //Initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        TextView signup = (TextView) findViewById(R.id.linksignin);
        builder = new AlertDialog.Builder(LoginActivity.this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Register.class));
            }
        });
        buttonLogin = (AppCompatButton) findViewById(R.id.button);

        //Adding click listener
        buttonLogin.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            String code = jsonObject.getString("Code");
                           String message = jsonObject.getString("Message");
                            if(message.equals("wELOCME")){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                            builder.setTitle("Server Response..!");
                           builder.setMessage(message);
                            displayAlert(code);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("email", editTextEmail.getText().toString());
                params.put("password", editTextPassword.getText().toString());

                return params;
            }
        };

        requestQueue.add(stringRequest);
        //singe.getMinstnace(getBaseContext()).addRequest(stringRequest);


    }






public void displayAlert(final String code) {

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

@Override
public void onClick(DialogInterface dialog, int which) {

        if(code.equals("reg_failed")) {
            editTextEmail.setText("");

            editTextPassword.setText("");
        }
    if(code.equals("reg_success")){
        finish();
        }
        }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();

        }}


