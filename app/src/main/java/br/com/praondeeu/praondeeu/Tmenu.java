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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Tmenu extends AppCompatActivity {
    CircleImageView itemFoto;
    EditText id;
    TextView text5,codev,tpev, categoria,tipoev;
    ListView listViewContatos;
    private CircleImageView circleImageView;
    ProgressDialog progresso;
    ContatosAdapter contatosAdapter;
    List <mMenu> lista;

    private String HOST = "http://192.168.15.9/webservices";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_tmenu );
        text5 =(TextView)findViewById ( R.id.text5 );
        codev = (TextView)findViewById ( R.id.codev);
        tpev = (TextView)findViewById ( R.id.tpev );
        categoria= (TextView)findViewById ( R.id.categoria );
        tipoev = (TextView)findViewById ( R.id.tipoev );
        listViewContatos = (ListView) findViewById ( R.id.listViewContatos );

        lista = new ArrayList <mMenu> (  );
        contatosAdapter = new ContatosAdapter ( Tmenu.this, lista );
        listViewContatos.setAdapter ( contatosAdapter );

        codev.setVisibility(View.INVISIBLE);
        categoria.setVisibility(View.INVISIBLE);
        tipoev.setVisibility(View.INVISIBLE);

        Intent intent = getIntent ();


        String codevento = (String) intent.getSerializableExtra ("TP");

        codev.setText (codevento);


        String cod = codev.getText ().toString ();
        String url = "";
        int A = Integer.parseInt(cod);
        if (A==1) {
            tpev.setText ( "***  B A I L E  ***");
        } else if(A==2){
            tpev.setText ( "***  S A M B A  ***");
        }else if(A==3){
            tpev.setText ( "***  B A L A D A   ***");
        }else if(A==4){
            tpev.setText ( "***  C I N E M A  ***");
        }else if(A==5){
            tpev.setText ( "***  E S P O R T E  ***");
        }else if(A==6){
            tpev.setText ( "***  FEIRA E EVENTO  ***");
        }else if(A==7){
            tpev.setText ( "***  T U R I S M O  ***");
        }else if(A==8){
            tpev.setText ( "***  P A R Q U E  ***");
        }else if(A==9){
            tpev.setText ( "***  G A S T R O N O M I A  ***");
        }else if(A==10){
            tpev.setText ( "***  S H O W  ***");
        }else if(A==11){
            tpev.setText ( "***  T E A T R O  ***");
        }else if(A==12){
            tpev.setText ( "***  B E L E Z A  ***");
        }
        listaMenus();

    }
    private void listaMenus(){

        progresso = new ProgressDialog (Tmenu.this);
        progresso.setMessage("Selecionando...");
        progresso.show();

        String cod = codev.getText ().toString ();
        String url = "";
        int A = Integer.parseInt(cod);
        if (A==1) {
            url = HOST + "/listaTmenuBaile.php";
        } else if (A==2) {
            url = HOST + "/listaTmenuSamba.php";
        }else if (A==3) {
            url = HOST + "/listaTmenuBalada.php";
        }else if (A==4) {
            url = HOST + "/listaTmenuCinema.php";
        }  else if (A==5) {
            url = HOST + "/listaTmenuEsporte.php";
        }else if (A==6) {
            url = HOST + "/listaTmenuFeira.php";
        }else if (A==7) {
            url = HOST + "/listaTmenuPasseio.php";
        }else if (A==8) {
            url = HOST + "/listaTmenuParque.php";
        }else if (A==9) {
            url = HOST + "/listaTmenuGastronomia.php";
        }else if (A==10) {
            url = HOST + "/listaTmenuShow.php";
        }else if (A==11) {
            url = HOST + "/listaTmenuTeatro.php";
        }else if (A==12) {
            url = HOST + "/listaTmenuBeleza.php";
        }

        Ion.with (getBaseContext ())

                .load(url)

                .asJsonArray ()

                .setCallback (new FutureCallback<JsonArray> () {

                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (int i = 0; i < result.size(); i++){
                            JsonObject obj = result.get(i).getAsJsonObject ();

                            mMenu c = new mMenu ();

                            c.setId(obj.get("id").getAsInt ());
                            c.setNome (obj.get("nome").getAsString ());
                            c.setFoto (obj.get("foto").getAsString ());
                            c.setCategoria (obj.get("categoria").getAsString ());
                            c.setTipo (obj.get("tipo").getAsString ());
                            c.setFllib (obj.get("fllib").getAsString ());



                            lista.add(c);

                        }
                        contatosAdapter.notifyDataSetChanged ();
                        progresso.hide();
                    }
                });

        listViewContatos.setOnItemClickListener ( new AdapterView.OnItemClickListener () {


            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {

                mMenu c = (mMenu) adapterView.getAdapter ().getItem ( i );
                categoria.setText ( String.valueOf ( c.getNome ())) ;

                tipoev.setText (String.valueOf ( c.getId () ));


               // itemclicado = (i);

                Intent intent = new Intent ( Tmenu.this, Teventos1.class );
                intent.putExtra ( "TP", codev.getText ().toString () );
                intent.putExtra ( "CATEGORIA", categoria.getText () );
                intent.putExtra ( "CODEV", codev.getText () );
                intent.putExtra ( "TPEV", tipoev.getText () );
                startActivity ( intent );


            }

         } );


    }

}
