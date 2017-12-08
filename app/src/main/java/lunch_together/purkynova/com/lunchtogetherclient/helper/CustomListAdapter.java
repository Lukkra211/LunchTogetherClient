package lunch_together.purkynova.com.lunchtogetherclient.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import lunch_together.purkynova.com.lunchtogetherclient.R;
import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;

public final class CustomListAdapter extends ArrayAdapter {

    private final List<Event> eventList;

    public CustomListAdapter(@NonNull Context context, int resource, @NonNull List<Event> objects) {
        super(context, resource, objects);

        this.eventList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.activity_list_row, null);
        }

        Event event = eventList.get(position);

        if (event != null) {
            TextView title = view.findViewById(R.id.list_row_title);
            TextView place = view.findViewById(R.id.list_row_place);
            TextView time = view.findViewById(R.id.list_row_time);

            title.setText(event.title);
            place.setText(event.place);
            time.setText(event.getTime());
        }

        return view;
    }
}
