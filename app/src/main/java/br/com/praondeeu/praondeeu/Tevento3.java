package br.com.praondeeu.praondeeu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Tevento3 extends AppCompatActivity {
    EditText idx;
    TextView descr4, spnTipo, tipoev;
    ImageView imgfoto;
    Button btnMapa;

    List<tabEventoImg> lista;
    ProgressDialog progresso;

    private String HOST = "http://192.168.15.9/webservices";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_tevento3 );

        idx = (EditText) findViewById ( R.id.idx );
        spnTipo = (TextView)findViewById ( R.id.itemSpnTipo );
        descr4 = (TextView)findViewById ( R.id.itemDescr4 );
        imgfoto = (ImageView)findViewById ( R.id.itemFoto );
        tipoev = (TextView)findViewById ( R.id.tipoev );
        btnMapa = (Button)findViewById ( R.id.btnMapa );

        idx.setVisibility(View.INVISIBLE);


        Intent intent = getIntent ();
        final String param = (String) intent.getStringExtra ( "ID" );
        final String param1 = (String) intent.getStringExtra ( "CATEG" );
        idx.setText ( param );
        tipoev.setText ( param1 );
        lista = new ArrayList<tabEventoImg> ();

        //  eventoAdapterImg = new EventoAdapterImg ( Tevento3.this, lista );
        btnMapa.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( Tevento3.this, MapsActivity.class );
                intent.putExtra ( "ID", param );
                intent.putExtra ( "CATEG", param1 );
                startActivity ( intent );

            }
        } );
        String url = HOST + "/readEventoImg.php";
        Ion.with (getBaseContext ())
                .load(url)
                .setBodyParameter ("ID", param )
                .asJsonArray ()
                .setCallback ( new FutureCallback<JsonArray> () {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        for (int i = 0; i < result.size(); i++){
                            JsonObject obj = result.get(i).getAsJsonObject ();

                            tabEventoImg c = new tabEventoImg ();

                            c.setId(obj.get("id").getAsInt ());
                            c.setFoto (obj.get("foto").getAsString ());
                            c.setDescr4 (obj.get("descr4").getAsString ());
                            c.setSpntipo ( obj.get("spntipo").getAsString ());

                            descr4.setText ( c.getDescr4 () );
                            spnTipo.setText ( c.getSpntipo () );

                            String fotoRecebida = HOST + "/" + c.getFoto ();
                            Picasso.get().load(fotoRecebida).into(imgfoto);

                        }

                    }
                } );

    }
}
