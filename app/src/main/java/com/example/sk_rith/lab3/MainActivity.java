package com.example.sk_rith.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {



    private ImageView currentImageView;
    private int currentRadioButtonId ;
    private int currentImageId ;
    private Button sendButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendButton = (Button) findViewById(R.id.send_id);
        editText = (EditText) findViewById(R.id.edit_text);
        currentImageView = (ImageView) findViewById(R.id.actor_image);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText.setText(((RadioButton)findViewById(currentRadioButtonId)).getText());

                Toast.makeText(getApplicationContext(), ((RadioButton)findViewById(currentRadioButtonId)).getText(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }

    public void actorChange(View view)
    {
        currentRadioButtonId =  view.getId();
        if(currentRadioButtonId == R.id.haruno_radio_button){
            currentImageView.setImageResource(R.drawable.haruno);
            currentImageId = R.drawable.haruno;
        }
        else if(currentRadioButtonId == R.id.hatake_radio_button){
            currentImageView.setImageResource(R.drawable.hatake);
            currentImageId = R.drawable.hatake;
        }
        else if(currentRadioButtonId == R.id.rocklee_radio_button){
            currentImageView.setImageResource(R.drawable.rocklee);
            currentImageId = R.drawable.rocklee;
        }
        else if(currentRadioButtonId == R.id.uchiha_radio_button) {
            currentImageView.setImageResource(R.drawable.uchiha);
            currentImageId = R.drawable.uchiha;
        }
        editText.setText(((RadioButton)findViewById(currentRadioButtonId)).getText());


    }

    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("currentImageId",currentImageId);

        outState.putInt("currentRadioButtonId",currentRadioButtonId);



    }
    protected void onRestoreInstanceState(Bundle saveInstanceState)
    {
        super.onRestoreInstanceState(saveInstanceState);
        if(saveInstanceState!=null) {
            currentRadioButtonId = saveInstanceState.getInt("currentRadioButtonId");
            currentImageId = saveInstanceState.getInt("currentImageId");

            currentImageView.setImageResource(currentImageId);

        }

    }
}
