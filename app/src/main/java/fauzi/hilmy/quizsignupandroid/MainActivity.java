package fauzi.hilmy.quizsignupandroid;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etFull, etEmail, etPass, etTempat, etAddress;
    Button btnSubmit, btnExit ;
    Spinner spinJob, spinSex;
    TextView lblHasil, btnTgl, lblResult;
    private int year, month, day;
    private Calendar calendar;
    Context context = this;
    String itemJob, itemSex, hasilSex;

    String[] dataJob = new String[]{
            "Pelajar", "Guru", "PNS"
    };

    String[] dataSex = new String[]{
            "L", "P", "NONE"
    };


    // TODO Difficult
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

        etUser = (EditText)findViewById(R.id.etUser);
        etFull = (EditText)findViewById(R.id.etFull);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        etTempat = (EditText)findViewById(R.id.etTempat);
        etAddress = (EditText)findViewById(R.id.etAddress);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnExit = (Button)findViewById(R.id.btnExit);
        btnTgl = (TextView)findViewById(R.id.btnTgl);
        spinJob = (Spinner)findViewById(R.id.spinJob);
        spinSex = (Spinner)findViewById(R.id.spinSex);
        lblHasil = (TextView)findViewById(R.id.lblHasil);
        lblResult = (TextView)findViewById(R.id.lblResult);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataJob);
        spinJob.setAdapter(adapter);

        spinJob.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemJob = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSex);
        spinSex.setAdapter(adapter1);

        spinSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //mengambil nilai dari posisi dan dijadikan string
                itemSex = parent.getItemAtPosition(position).toString();
                if (itemSex.equalsIgnoreCase("NONE")) {
                    final Dialog dialogA = new Dialog(context);
                    //memanggil layout custom
                    dialogA.setContentView(R.layout.layout_customma);
                    //mengatur title
                    dialogA.setTitle("Warning!");

                    //dialog.findviewbyid ini adalah maksudnya adalah memanggil id yang ada di custom layout
                    Button btnTidak = (Button)dialogA.findViewById(R.id.button);
                    btnTidak.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //ketika dipencet ok maka alert dialog nya hilang
                            dialogA.dismiss();
                        }
                    });

                    dialogA.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                //memanggil layout custom
                dialog.setContentView(R.layout.layout_customa);
                //mengatur title
                dialog.setTitle("Warning!");

                //memanggil button OK
                //dialog.findviewbyid ini adalah maksudnya adalah memanggil id yang ada di custom layout
                Button btnTidak = (Button)dialog.findViewById(R.id.button);
                btnTidak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //ketika dipencet ok maka alert dialog nya hilang
                        dialog.dismiss();
                    }
                });
                Button btnYa = (Button)dialog.findViewById(R.id.button2);
                btnYa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity.this.finish();
                    }
                });

                dialog.show();
            }
        });



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String aUser = etUser.getText().toString();
                final String aFull = etFull.getText().toString();
                final String aEmail = etEmail.getText().toString();
                final String aPass = etPass.getText().toString();
                final String aTempat = etTempat.getText().toString();
                final String aAddress = etAddress.getText().toString();
                if(aUser.isEmpty()){
                    etUser.setError("Nilai Tidak Boleh Kosong");
                }else if (aFull.isEmpty()){
                    etFull.setError("Nilai tidak boleh kosong");
                }else if (aEmail.isEmpty()){
                    etEmail.setError("Nilai tidak boleh kosong");
                }else if (aPass.isEmpty()){
                    etPass.setError("Nilai tidak boleh kosong");
                }else if (aTempat.isEmpty()){
                    etTempat.setError("Nilai tidak boleh kosong");
                }else if (aAddress.isEmpty()){
                    etAddress.setError("Nilai tidak boleh kosong");
                }else{
                    final Dialog dialogB = new Dialog(context);
                    //memanggil layout custom
                    dialogB.setContentView(R.layout.layout_custommma);
                    //mengatur title
                    dialogB.setTitle("Warning!");
                    //dialog.findviewbyid ini adalah maksudnya adalah memanggil id yang ada di custom layout
                    Button btnTidak = (Button)dialogB.findViewById(R.id.btnBatal);
                    btnTidak.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //ketika dipencet ok maka alert dialog nya hilang
                            dialogB.dismiss();
                        }
                    });
                    Button btnYa = (Button)dialogB.findViewById(R.id.btnSudah);
                    btnYa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (itemSex.equalsIgnoreCase("L")) {
                                hasilSex = "Laki Laki";
                            }else if (itemSex.equalsIgnoreCase("P")) {
                                hasilSex = "Perempuan";
                            }

                            lblHasil.setText("Halo, " + aUser + ", Full Name : " + aFull + ", Email : " + aEmail + ", Pass : " + aPass + ", Pekerjaan : " +
                                    itemJob + ", Gender : " + hasilSex + ", Tempat Lahir : " + aTempat + ", Tgl Lahir : " + (new StringBuilder().append(day).append("/")
                                    .append(month).append("/").append(year)) + ", Address : " + aAddress);

                        }
                    });

                    dialogB.show();

                }
            }
        });


    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        //akan menampilkan teks ketika kalendar muncul setelah menekan tombol
        Toast.makeText(getApplicationContext(), "Pilih Tangal", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
//        lblResult.setText(new StringBuilder().append(day).append("/")
//                .append(month).append("/").append(year));
    }


}
