package fauzi.hilmy.quizsignupandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class getProfile extends AppCompatActivity {

    TextView lblUser, lblFull, lblEmail, lblPass, lblJob, lblGender, lblBod, lblAddress, lblTempat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_profile);

        lblUser = (TextView)findViewById(R.id.getUser);
        lblFull = (TextView)findViewById(R.id.getFull);
        lblEmail = (TextView)findViewById(R.id.getEmail);
        lblPass = (TextView)findViewById(R.id.getEmail);
        lblJob = (TextView)findViewById(R.id.getJob);
        lblGender = (TextView)findViewById(R.id.getSex);
        lblBod = (TextView)findViewById(R.id.getTgl);
        lblAddress = (TextView)findViewById(R.id.getAddress);
        lblTempat = (TextView)findViewById(R.id.getTempat);

        Intent a1 = getIntent();
        //mengambil data yang sudah di put sebelumnya dengan variable nama
        String ambilUser = a1.getStringExtra("user");
        String ambilFull = a1.getStringExtra("full");
        String ambilEmail = a1.getStringExtra("email");
        String ambilPass = a1.getStringExtra("pass");
        String ambilJob = a1.getStringExtra("job");
        String ambilGender = a1.getStringExtra("gender");
        String ambilBod = a1.getStringExtra("bod");
        String ambilAddress = a1.getStringExtra("address");
        String ambilTempat = a1.getStringExtra("tempat");

        //menampilkan nilai ke text view
        lblUser.setText("Username : " + ambilUser);
        lblFull.setText("FullName : " + ambilFull);
        lblEmail.setText("Email : " + ambilEmail);
        lblPass.setText("Password : " + ambilPass);
        lblJob.setText("Job : " + ambilJob);
        lblGender.setText("Gender : " + ambilGender);
        lblBod.setText("Birth Of Date : " + ambilBod);
        lblAddress.setText("Address : " + ambilAddress);
        lblTempat.setText("Place Of Birth : " + ambilTempat);


    }
}
