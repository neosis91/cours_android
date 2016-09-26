package bertrandjaunet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {


    private ListView demoListView;
    private ArrayAdapter<String> monArray;
    private Button monbouton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        demoListView = (ListView)findViewById(R.id.maliste);


        //array
        final String[] values = new String[] {
                "Benji",
                "JC",
                "Yves St-Laurent",
                "Bernard l'hermute"
        };

        // final ArrayList<String> list = new ArrayList<String>(Arrays.asList(values));
       // monArray = new ArrayAdapter<String>(this,R.layout.listview,R.id.text_view,list);
        monArray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice);
        demoListView.setAdapter(monArray);
        monArray.addAll(values);
        demoListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        monbouton =(Button) findViewById(R.id.toast_button);

        /*demoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           /* @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView text = (TextView) view.findViewById(R.id.text_view);

                list.remove(position);
                monArray.notifyDataSetChanged();

                Toast.makeText(MainActivity.this,"Supression de : " +text.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });*/

        monbouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p = demoListView.getCheckedItemPosition();
                if(p!=ListView.INVALID_POSITION) {
                    String s = ((TextView) demoListView.getChildAt(p)).getText().toString();
                    Toast.makeText(MainActivity.this, "Vous avez selectionné " + s, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Rien de sélectionner...", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}





