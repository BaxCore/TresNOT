package com.example.tresnot;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class DaMenu extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.hom:
                startActivity(new Intent(this, MainActivity.class));
                return true;

            case R.id.audio:
                startActivity(new Intent(this, LatestMuz.class));
                return true;

            case R.id.ccod:
                startActivity(new Intent(this, LocationM.class));
                return true;

            case R.id.Alarm:
                startActivity(new Intent(this, testmehere.class));
                return true;

            case R.id.placez:
                startActivity(new Intent(this, SavePlace.class));
                return true;

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
                Ints.setData(Uri.parse("tel:0754923852"));
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
