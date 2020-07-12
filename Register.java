package com.example.abdulali.careerkey;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    Button signup;
    TextView Name, Email, Password;
    String name, email, password;
    String url = "http://192.168.43.164/foip/register.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = (TextView) findViewById(R.id.name);
        Email = (TextView) findViewById(R.id.email);
        Password = (TextView) findViewById(R.id.password);

        builder = new AlertDialog.Builder(Register.this);

        signup = (Button) findViewById(R.id.REGISTER);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = Name.getText().toString();
                email = Email.getText().toString();
                password = Password.getText().toString();

                if(name.equals("") || email.equals("") ||
                        password.equals("")) {
                    builder.setTitle("Something Went Wrong");
                    builder.setMessage("Please Fill All Fields");
                    displayAlert("input_error");

                }else {

                        RequestQueue requestQueue = Volley.newRequestQueue(Register.this);


                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {

                                            finish();
                                            JSONArray jsonArray = new JSONArray(response);
                                            JSONObject jsonObject = jsonArray.getJSONObject(0);

                                             String code =jsonObject.getString("Code");
                                            if(code.contains("reg_success"))
                                                finish();
                                            String message =jsonObject.getString("Message");
                                            builder.setTitle("Server Response..!");
                                            builder.setMessage(message);
                                            displayAlert(code);
                                            finish();
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }

                    }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                               Map<String,String> params = new HashMap<String, String>();
                                params.put("name",name);
                                params.put("email",email);
                                params.put("password",password);
                                return params;
                            }
                        };
                            requestQueue.add(stringRequest);
                        //singe.getMinstnace(getBaseContext()).addRequest(stringRequest);
                    }
                }


        });
    }

    public void displayAlert(final String code) {

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(code.equals("reg_failed"))
                {
                    Name.setText("");
                    Email.setText("");
                    Password.setText("");
                }
                if(code.equals("reg_success")){
                    finish();
                }
            }
        });
           AlertDialog alertDialog =builder.create();
        alertDialog.show();

    }}




