package br.com.praondeeu.praondeeu;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.AsyncLayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class EventoAdapter extends BaseAdapter {

    private Context ctx;
    private List<tabEvento> lista;

    private String HOST = "http://192.168.15.9/webservices";

    public EventoAdapter(Context ctx2, List<tabEvento> lista2){
        ctx = ctx2;
        lista = lista2;
    }
    @Override
    public int getCount() {
        return lista.size ();
    }

    @Override
    public tabEvento getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = null;
        if (view == null){
            LayoutInflater inflater = ((Activity)ctx).getLayoutInflater ();
            v = inflater.inflate ( R.layout.item_lista, null );
         } else {
            v = view;
        }
        tabEvento c = getItem ( i );

        TextView itemDescr1 = (TextView) v.findViewById ( R.id.itemDescr1 );
        TextView itemDescr2 = (TextView) v.findViewById ( R.id.itemDescr2 );
        TextView itemDescr3 = (TextView) v.findViewById ( R.id.itemDescr3 );
        TextView itemLocal = (TextView) v.findViewById ( R.id.itemLocal );
        ImageView itemFoto = (ImageView)v.findViewById ( R.id.itemFoto ) ;


        String fotoRecebida = HOST + "/" + c.getFoto ();
        Picasso.get().load(fotoRecebida).into(itemFoto);

        itemDescr1.setText ( c.getDescr1 () );
        itemDescr2.setText ( c.getDescr2 () );
        itemDescr3.setText ( c.getDescr3 () );
        itemLocal.setText ( c.getLocal () );

        return v;
    }
}
