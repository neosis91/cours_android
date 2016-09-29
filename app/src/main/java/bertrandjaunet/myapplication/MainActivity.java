package bertrandjaunet.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;



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

        monArray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice);
        demoListView.setAdapter(monArray);
        monArray.addAll(values);
        demoListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        monbouton =(Button) findViewById(R.id.toast_button);
        monbouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray sp = demoListView.getCheckedItemPositions();
                StringBuffer str = new StringBuffer();
                for(int i=0;i<sp.size();i++){
                    if(sp.valueAt(i)==true){
                        String s = ((TextView) demoListView.getChildAt(i)).getText().toString();
                        str = str.append(" "+s);
                    }
                }
                Toast.makeText(MainActivity.this, "Vous avez selectionné  "+str.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}





