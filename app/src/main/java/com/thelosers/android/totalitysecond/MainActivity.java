package com.thelosers.android.totalitysecond;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private String mPackageName = "com.thelosers.android.totality";
  private String mSharedPreferenceName = "Totality shared preferenced";
  private String mSharedPreferenceKey = "Totality";
  private TextView mIntroTextview;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mIntroTextview = (TextView) findViewById(R.id.intro_textview);
    try {
      Context con = createPackageContext(mPackageName, 0);
      SharedPreferences pref = con.getSharedPreferences(
          mSharedPreferenceName, Context.MODE_PRIVATE);
      String username = pref.getString(mSharedPreferenceKey, null);

      if (username == null) {
        mIntroTextview.setText("Please login through Totality First App !!");
      } else {
        mIntroTextview.setText("Hey !!" + username + "\n" + "Login successfully !!!");
      }
    } catch (NameNotFoundException e) {
      Log.e("Not data shared", e.toString());
    }
  }
}
