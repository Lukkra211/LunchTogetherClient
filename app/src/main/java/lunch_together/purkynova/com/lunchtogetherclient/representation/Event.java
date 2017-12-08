package lunch_together.purkynova.com.lunchtogetherclient.representation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Lukáš Krajíček
 */
public final class Event {
    public final String title;
    public final ArrayList<User> users;
    public final String place;
    public final String note;
    public final Date time;

    public Event(String title, ArrayList<User> users, String time, String place,String note)
            throws ParseException {
        this.title = title;
        this.users = users;
        this.place = place;
        this.note = note;

        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
    }

    public String getTime() {
        return new SimpleDateFormat("HH:mm").format(this.time);
    }
}
