package lunch_together.purkynova.com.lunchtogetherclient;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import lunch_together.purkynova.com.lunchtogetherclient.helper.CustomListAdapter;
import lunch_together.purkynova.com.lunchtogetherclient.model.Data;
import lunch_together.purkynova.com.lunchtogetherclient.model.Model;
import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;

public class EventListActivity extends ListActivity {

    private ListView listView;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initParams();
        initUI();
    }

    private void initParams() {
        this.model = new Model();
        this.listView = getListView();

        model.initializeData(String.valueOf(this.getIntent().getExtras().getInt("id")));
    }

    private void initUI() {
        listView.setOnItemClickListener(new OnItemClick());

        CustomListAdapter eventAdapter = new CustomListAdapter(
                this,
                R.layout.activity_list_row,
                Model.data.events
        );
        setListAdapter(eventAdapter);
    }

    class OnItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(getApplicationContext(), EventActivity.class);
            intent.putExtra("EventID", Model.data.events.get(i).id);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.empty);
        }
    }
}
