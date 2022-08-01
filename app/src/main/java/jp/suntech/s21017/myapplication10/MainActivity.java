package jp.suntech.s21017.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCheck = findViewById(R.id.btConfirm);
        CheckListener listener = new CheckListener();
        btCheck.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);

        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(listener);

    }

    private class CheckListener implements View.OnClickListener
    {
        @Override
        public void  onClick(View view)
        {
            EditText input = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etMail);
            EditText input3 = findViewById(R.id.etComment);

            String inputStr = input.getText().toString();
            String inputStr2 = input2.getText().toString();
            String inputStr3 = input3.getText().toString();

            String show = "名前:" +inputStr+ " メール:"+ inputStr2+ " 質問内容:"+inputStr3;

            int id = view.getId();

            switch (id)
            {
                case R.id.btConfirm:
                    DialogMaker dialogflagment = new DialogMaker();
                    dialogflagment.show(getSupportFragmentManager(),"DialogMaker");
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;

                case R.id.btClear:
                    input.setText("");
                    input2.setText("");
                    input3.setText("");
                    break;

                case R.id.btSend:
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;

            }
        }
    }
}