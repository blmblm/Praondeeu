package br.com.praondeeu.praondeeu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Teventos extends AppCompatActivity {

    TextView text5,codev,tpev,categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_teventos );

        text5 =(TextView)findViewById ( R.id.text5 );
        codev = (TextView)findViewById ( R.id.codev);
        tpev = (TextView)findViewById ( R.id.tpev );
        categoria = (TextView)findViewById ( R.id.categoria );

        Intent intent = getIntent ();
        String codevento = (String) intent.getSerializableExtra ("TP");
        String categoriax = (String) intent.getSerializableExtra ( "CATEGORIA" ) ;
        String codevx = (String) intent.getSerializableExtra ( "CODEV" ) ;
        String tpevx = (String) intent.getSerializableExtra ( "TPEV" ) ;

        categoria.setText ( categoriax );
        codev.setText ( codevx );
        tpev.setText ( tpevx );

      //  String cod = codev.getText ().toString ();
        String url = "";
        int A = Integer.parseInt(codevento);

    }
}
