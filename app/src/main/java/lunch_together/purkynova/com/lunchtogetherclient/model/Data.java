package lunch_together.purkynova.com.lunchtogetherclient.model;

import org.json.JSONObject;

import java.util.ArrayList;

import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;
import lunch_together.purkynova.com.lunchtogetherclient.representation.User;

/**
 * Created by vojtech on 12/8/17.
 */

public class Data
{
    public static ArrayList<Event> events;
    public static ArrayList<User> users;

    public Data(JSONObject response)
    {

    }

}
