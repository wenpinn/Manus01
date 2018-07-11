package tools.wpfang.manus01;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        resultText=findViewById(R.id.resultText);
        registerForContextMenu(ed1);
        registerForContextMenu(ed2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_file,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menu_setting:
               Intent it=new Intent(this,SettingScreen.class);
               startActivity(it);
            break;
            case R.id.heart_menu:
                Toast.makeText(this,"heart selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile_menu:
                Toast.makeText(this,"profile selected",Toast.LENGTH_SHORT).show();

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch(v.getId())
        {
            case R.id.ed1:
                getMenuInflater().inflate(R.menu.edit1_menu,menu);
                break;
            case R.id.ed2:
                getMenuInflater().inflate(R.menu.edit2_menu,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String s1=ed1.getText().toString();
        String s2=ed2.getText().toString();
        switch(item.getItemId())
        {
            case R.id.red:

                resultText.setText(s1);
                resultText.setTextColor(Color.RED);
                break;
            case R.id.green:
                resultText.setText(s1);
                resultText.setTextColor(Color.GREEN);
                break;
            case R.id.bold_text:
                resultText.setText(s2);
                resultText.setTextColor(Color.BLACK);
                resultText.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
                break;
            case R.id.italic_text:
                resultText.setText(s2);
                resultText.setTextColor(Color.BLACK);
                resultText.setTypeface(Typeface.DEFAULT,Typeface.ITALIC);
                break;
        }
        return true;
    }
}

