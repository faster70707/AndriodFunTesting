package nyc.muaadh_melhi_develpoer.andriodgooglefundmantal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    public static final int SECOND_ACTIVITY_REQUEST_CODE = 1;
    private EditText edTxSecActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edTxSecActivity = findViewById(R.id.input_sec_edtx);
    }

    public void SecButtonClick(View view) {
        String edTextString = edTxSecActivity.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("key", edTextString);
        setResult(RESULT_OK, intent);
        finish();
    }


}
