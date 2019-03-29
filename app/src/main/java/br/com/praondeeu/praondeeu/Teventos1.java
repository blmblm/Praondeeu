package br.com.praondeeu.praondeeu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teventos1 extends AppCompatActivity {
    TextView codev,categoria,tpev,text5;

    ListView listViewEvento;
    ProgressDialog progresso;
    private String HOST = "http://192.168.15.9/webservices";

    EventoAdapter eventoAdapter;
    List<tabEvento> lista;

    EditText idx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_teventos1 );

        text5 =(TextView)findViewById ( R.id.text5 );
        codev = (TextView)findViewById ( R.id.codev);
        tpev = (TextView)findViewById ( R.id.tpev );
        categoria = (TextView)findViewById ( R.id.categoria );
        idx = (EditText)findViewById ( R.id.idx );

        codev.setVisibility(View.INVISIBLE);
        tpev.setVisibility(View.INVISIBLE);
        idx.setVisibility(View.INVISIBLE);

        listViewEvento = (ListView) findViewById ( R.id.listViewEvento );

        lista = new ArrayList <tabEvento> (  );
        eventoAdapter = new EventoAdapter ( Teventos1.this, lista );
        listViewEvento.setAdapter ( eventoAdapter );

        Intent intent = getIntent ();
        String codevento = (String) intent.getSerializableExtra ("TP");
        String categoriax = (String) intent.getSerializableExtra ( "CATEGORIA" ) ;
        String codevx = (String) intent.getSerializableExtra ( "CODEV" ) ;
        String tpevx = (String) intent.getSerializableExtra ( "TPEV" ) ;

        categoria.setText ( categoriax );
        codev.setText ( codevx );
        tpev.setText ( tpevx );

        listaEventos();

    }

    private void listaEventos(){
        final String tipox = tpev.getText ().toString ();
        progresso = new ProgressDialog (Teventos1.this);
        progresso.setMessage("Selecionando...");
        progresso.show();

        String url = HOST + "/listaBaile.php";


        Ion.with(getBaseContext ())
           .load ( url )
           .setBodyParameter ( "tipo", String.valueOf (tipox) )
           .asJsonArray ()
           .setCallback ( new FutureCallback <JsonArray> () {

               @Override

               public void onCompleted(Exception e, JsonArray result) {
                   if (result.size () > 0) {
                       for (int i = 0; i < result.size (); i++) {
                           JsonObject obj = result.get ( i ).getAsJsonObject ();

                           tabEvento c = new tabEvento ();
                           c.setId ( obj.get ( "id" ).getAsInt () );
                           c.setDescr1 ( obj.get ( "descr1" ).getAsString () );
                           c.setDescr2 ( obj.get ( "descr2" ).getAsString () );
                           c.setDescr3 ( obj.get ( "descr3" ).getAsString () );
                           c.setLocal ( obj.get ( "local" ).getAsString () );
                           c.setFoto ( obj.get ( "foto" ).getAsString () );
                           c.setCategoria ( obj.get("categoria").getAsString () );

                           lista.add ( c );

                       }

                       eventoAdapter.notifyDataSetChanged ();
                       progresso.hide ();
                   } else {

                       Intent intent = new Intent ( Teventos1.this, NaoSelecionou.class );
                       startActivity ( intent );
                   }
               }
           } );

        listViewEvento.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long id) {

                tabEvento c = (tabEvento) adapterView.getAdapter ().getItem ( i );
                idx.setText (String.valueOf (c.getId ()));


                Intent intent = new Intent ( Teventos1.this, Tevento3.class );
                intent.putExtra ( "ID", (String.valueOf ( c.getId ())));
                intent.putExtra ( "CATEG", c.getCategoria () );

                startActivity ( intent );

            }

            private void Idx(String s) {
            }

            private void Id(String s) {
            }

        } );

    }
}

