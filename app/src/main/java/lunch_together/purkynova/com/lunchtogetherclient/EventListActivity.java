package lunch_together.purkynova.com.lunchtogetherclient;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import lunch_together.purkynova.com.lunchtogetherclient.helper.CustomListAdapter;
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
    }

    private void initUI() {
        CustomListAdapter eventAdapter = new CustomListAdapter(
                this,
                R.layout.activity_list_row,
                Model.data.events
        );
        setListAdapter(eventAdapter);
    }
}
