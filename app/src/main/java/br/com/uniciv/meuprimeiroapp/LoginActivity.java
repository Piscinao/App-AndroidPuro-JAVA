package br.com.uniciv.meuprimeiroapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edtLogin123 = findViewById(R.id.edtLogin);
        final EditText edtSenha123 = findViewById(R.id.edtSenha);

        Button btnLogar = findViewById(R.id.btnAutenticar);

        btnLogar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtLogin123.getText().toString().equals("ALUNO") &&
                   edtSenha123.getText().toString().equals("123")) {
                   // Como enviar para outra tela tipo ROTAS
                   Intent it = new Intent(getApplicationContext(), SegundaTelaActivity.class);
                   it.putExtra("msg", edtLogin123.getText().toString());
                   startActivity(it);

                } else {
                    Snackbar.make(findViewById(R.id.activity_login),
                            "Usuário e senha inválidos",
                            Snackbar.LENGTH_LONG).show();
                }
                /*
                // Notificação padrão do android
                Toast.makeText(getApplicationContext(), "Login digitado:" + edtLogin123.getText(), Toast.LENGTH_LONG).show();

                // Notificação no fim da tela com ação de desfazer
                Snackbar.make(findViewById(R.id.activity_login), "Senha digitada: " + edtSenha123.getText(),
                        Snackbar.LENGTH_LONG)
                        .setAction("Ação", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(findViewById(R.id.activity_login),
                                        "acao desfeita",
                                        Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                        */

            }

        });
    }

    //Torna disponível o menu e repete quantas vezes for necessário na tela
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Quando uma opção for selecionada faz uma ação
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_pesquisar:
                Toast.makeText(this, "pesquisar",
                        Toast.LENGTH_SHORT).show();
            break;

            case R.id.action_settings:
                Toast.makeText(this, "settings",
                        Toast.LENGTH_SHORT).show();
                break;

            // Faz fechar aplicação porém minimiza não da um destroy
            case R.id.action_sair:
                finish();
                break;
            default:
                break;

        }
        return true;
    }
}
