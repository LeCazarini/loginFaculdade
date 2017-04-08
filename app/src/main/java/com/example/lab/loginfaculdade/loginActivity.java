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


public class loginActivity extends Activity {

    EditText editTextSenha, editTextEmail;
    Button buttonEntrar, buttonNovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        if(UserSingleton.getInstance().sessionUser == null) {

            editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            editTextSenha = (EditText) findViewById(R.id.editTextSenha);
            buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
            buttonNovo = (Button) findViewById(R.id.buttonNovo);

            buttonEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    login();
                }
            });

            buttonNovo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    novoUsuario();
                }
            });
        }else{
            home();
        }

    }



    public void home(){
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }

    public void login(){
        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        User user = UserSingleton.getInstance().hashMapUser.get(email);
        if(user != null){
            if(senha.contentEquals(user.senha)){

                UserSingleton.getInstance().sessionUser = user;

                home();

            }else{
                Toast.makeText(this,"Senha invalida",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Usuario não encontrado",Toast.LENGTH_LONG).show();
        }


    }

    public void novoUsuario(){
        Intent intent = new Intent(this, registroActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
