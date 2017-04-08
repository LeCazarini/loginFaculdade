package com.example.lab.loginfaculdade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab.loginfaculdade.model.User;
import com.example.lab.loginfaculdade.singleton.UserSingleton;


public class registroActivity extends Activity {

    EditText nomeEditText;
    EditText emailEditText;
    EditText senhaEditText;
    Button salvarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_activity);
        nomeEditText = (EditText) findViewById(R.id.nomeNovo);
        emailEditText = (EditText) findViewById(R.id.emailNovo);
        senhaEditText = (EditText) findViewById(R.id.senhaNovo);
        salvarButton = (Button) findViewById(R.id.salvarNovo);

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }

        });

    }


    public void registro(){
        String nome = nomeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String senha = senhaEditText.getText().toString();

        User user = new User();
        user.email = email;
        user.senha = senha;
        user.nome = nome;

        UserSingleton.getInstance().hashMapUser.put(email, user);

        Toast.makeText(getApplication(),"Usuario cadastrado com sucesso",Toast.LENGTH_LONG).show();
        login();
    }


    public void login(){
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_novo, menu);
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
