package br.com.praondeeu.praondeeu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContatosAdapter extends BaseAdapter {
    private Context ctx;
    private List <mMenu> lista;
    private String HOST = "http://192.168.15.9/webservices";
    public ContatosAdapter(Context ctx2, List <mMenu> lista2){
        ctx = ctx2;
        lista = lista2;
    }
    private CircleImageView circleImageView;
    @Override
    public int getCount() {
        return lista.size ();
    }

    @Override
    public Contato getItem(int i) {
        return lista.get ( i );
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = null;

        if (view ==  null){
            LayoutInflater inflater = ((Activity)ctx).getLayoutInflater ();
            v = inflater.inflate(R.layout.item_lista1, null);

        } else{
            v = view;
        }


        Contato c = getItem ( i );
        ImageView itemFoto= (ImageView)v.findViewById (R.id.itemFoto);
        TextView itemNome = (TextView) v.findViewById (R.id.itemNome);

        String fotorecebida = HOST + "/" + c.getFoto ();


         Picasso.get().load  (fotorecebida)
               .resize(300,200)
               .into (itemFoto);

        itemNome.setText (c.getNome ());


        return v;
    }
}
