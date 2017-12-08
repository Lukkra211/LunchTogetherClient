package lunch_together.purkynova.com.lunchtogetherclient;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initParams();
        initUI();
    }

    private void initParams() {
        this.listView = getListView();
    }

    private void initUI() {

    }
}
