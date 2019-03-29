package br.com.praondeeu.praondeeu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuMenu extends AppCompatActivity {

    CircleImageView baile, samba,balada,cinema,esporte,feira,passeio,
            parque,gastronomia,show,teatro,beleza;
    ImageView imageV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_menu_menu );
        baile = (CircleImageView)findViewById (R.id.baile);
        samba = (CircleImageView)findViewById (R.id.samba);
        balada = (CircleImageView)findViewById (R.id.balada);
        cinema = (CircleImageView)findViewById (R.id.cinema);
        esporte = (CircleImageView)findViewById (R.id.esporte);
        feira = (CircleImageView)findViewById (R.id.feira);
        passeio = (CircleImageView)findViewById (R.id.passeio);
        parque = (CircleImageView)findViewById (R.id.parque);
        gastronomia = (CircleImageView)findViewById (R.id.gastronomia);
        show = (CircleImageView)findViewById (R.id.show);
        teatro = (CircleImageView)findViewById (R.id.teatro);
        beleza = (CircleImageView)findViewById (R.id.beleza);
        imageV1 = (ImageView)findViewById ( R.id.imageV1 );

        baile.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent baileeve = new Intent (MenuMenu.this, Tmenu.class);

                baileeve.putExtra("TP", "1");
                startActivity (baileeve);

            }
        });
        samba.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "2");
                startActivity (sambaeve);
            }
        });
        balada.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "3");
                startActivity (sambaeve);
            }
        });

        cinema.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "4");
                startActivity (sambaeve);

            }
        });
        esporte.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "5");
                startActivity (sambaeve);

            }
        });
        feira.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "6");
                startActivity (sambaeve);

            }
        });
        passeio.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "7");
                startActivity (sambaeve);

            }
        });
        parque.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "8");
                startActivity (sambaeve);

            }
        });
        gastronomia.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "9");
                startActivity (sambaeve);

            }
        });
        show.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "10");
                startActivity (sambaeve);

            }
        });
        teatro.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);

                sambaeve.putExtra("TP", "11");
                startActivity (sambaeve);

            }
        });
        beleza.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sambaeve = new Intent (MenuMenu.this, Tmenu.class);
                sambaeve.putExtra("TP", "12");
                startActivity (sambaeve);

            }
        });


    }


}
