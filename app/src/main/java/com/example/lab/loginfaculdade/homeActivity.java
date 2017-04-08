package com.example.lab.loginfaculdade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab.loginfaculdade.model.User;
import com.example.lab.loginfaculdade.singleton.UserSingleton;


public class homeActivity extends Activity {

    EditText nomeEditText;
    Button buttonlogoff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        User user = UserSingleton.getInstance().sessionUser;

        nomeEditText = (EditText) findViewById (R.id.textNovo);

        nomeEditText.setText(user.nome);

        if(UserSingleton.getInstance().sessionUser == null) {


            buttonlogoff = (Button) findViewById(R.id.buttonlogoff);

            buttonlogoff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sair();
                }
            });

        }

    }

    public void sair(){
        UserSingleton.getInstance().sessionUser = null;
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
