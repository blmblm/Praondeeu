package br.com.praondeeu.praondeeu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        iniciaSplash();

    }
    public void iniciaSplash(){
        setContentView ( R.layout.activity_main );

        new Thread ( new Runnable () {
            @Override
            public void run() {
                counter ++;

                try{
                    while (counter == 1 || counter <= 5){
                        Thread.sleep ( 1000 );
                        counter ++;
                    }
                }catch (InterruptedException e){
                    e.printStackTrace (  );
                }

                if (counter == 6){
                    Intent it = new Intent ( MainActivity.this, MenuMenu.class );
                    startActivity ( it );
                    counter ++;
                    finish();
                }

            }
        } ).start ();
       // finish();

    }
}
