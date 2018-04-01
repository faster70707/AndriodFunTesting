package nyc.muaadh_melhi_develpoer.andriodgooglefundmantal;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static nyc.muaadh_melhi_develpoer.andriodgooglefundmantal.SecondActivity.SECOND_ACTIVITY_REQUEST_CODE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = MainActivity.class.getSimpleName();
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btTextMain = findViewById(R.id.go_to_secA_act);
        editText = findViewById(R.id.edit_search);
        btTextMain.setOnClickListener(this);
        Toast.makeText(this, "on Create done", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate: ");
        Uri call = Uri.parse("tel:1234567890");
        Intent intent2 = new Intent(Intent.ACTION_DIAL, call);
        //  intent2.setData(Uri.parse("tel:1234567890"));
        if (intent2.resolveActivity(getPackageManager()) != null) {
            startActivity(intent2);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "on start done", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "on start: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        editText.setText("");
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
        Toast.makeText(this, "on resume done", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "on resume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "on pause done", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "on pause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "on stop done", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "on stop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "on restart done", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "on restart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "on destroy done", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "on destroy: ");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE &&
                resultCode == RESULT_OK &&
                data != null) {
            String valueComing = data.getExtras().getString("key");
            EditText editMain = findViewById(R.id.edit1);
            editMain.setText(valueComing);
        }

    }

    public void onSearch(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        String query = editText.getText().toString();
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
