package utng.edu.mx.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Gustavo on 20/04/2016.
 */
public class ListaGameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lsvPreguntas;
    private String[] preguntas;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_layout);
        initComponents();
    }

    private void initComponents() {
        bundle=new Bundle();
        lsvPreguntas=(ListView)findViewById(R.id.lsv_preguntas);
        preguntas=getResources().getStringArray(R.array.numero_preguntas);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.item,R.id.txv_item_game,preguntas);
        lsvPreguntas.setAdapter(adapter);

        lsvPreguntas.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        bundle.putString("Pregunta",preguntas[position]);
        bundle.putInt("posicion", position);
        Log.e("Posicion", "onItemClick:  "+position );
        startActivity(new Intent(ListaGameActivity.this, GameActivity.class).putExtras(bundle));
    }
}
