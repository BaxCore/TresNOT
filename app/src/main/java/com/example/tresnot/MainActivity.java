package com.example.tresnot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] types={"upercomputer", "Mainframe", "Server Computer", "Workstation Computer",
            "Personal Computer or PC", "Microcontroller","Smartphone"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Addpterr(this, types));
*/

    }
    public void sendMessage(View view){

        EditText message = (EditText)findViewById(R.id.message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.audio:
                startActivity(new Intent(this, LatestMuz.class));
                return true;
            case R.id.ccod:
                startActivity(new Intent(this, LocationM.class));
                return true;
            case R.id.Alarm:
                startActivity(new Intent(this, ));
            case R.id.SendEmail  :
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String whoRec[] = {"bvicxbax@gmail.com, markruhinda47@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, whoRec);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Kiki nawe");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello this is a stupid Guy");
                intent.setType("message/rfc822");
                startActivity(intent);
                return true;

            case R.id.CallMe:
                Intent Ints = new Intent(Intent.ACTION_DIAL);
                Ints.setData(Uri.parse("tel:0706944635"));
             /*   if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    return TODO;
                }*/
                startActivity(Ints);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
