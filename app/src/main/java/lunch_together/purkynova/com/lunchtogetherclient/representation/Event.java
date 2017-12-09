package lunch_together.purkynova.com.lunchtogetherclient.representation;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Lukáš Krajíček
 */
public final class Event {
    public final int id;
    public final String title;
    public final ArrayList<User> users;
    public final String note;
    public final Date time;
    public final Restaurant restaurant;

    public Event(int id, String title, ArrayList<User> users, String time, String note, Restaurant restaurant) throws ParseException {
        this.id = id;
        this.title = title;
        this.users = users;
        this.note = note;
        this.restaurant = restaurant;
        this.time = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(time);

    }

    public String getTime() {
        return new SimpleDateFormat("HH:mm").format(this.time);
    }

    public String toString() {
        return String.valueOf(title);
    }
}
