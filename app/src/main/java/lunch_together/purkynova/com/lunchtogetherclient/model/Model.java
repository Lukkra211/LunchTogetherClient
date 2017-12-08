package lunch_together.purkynova.com.lunchtogetherclient.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;
import lunch_together.purkynova.com.lunchtogetherclient.representation.User;

/**
 * Created by vojtech on 12/8/17.
 */

public class Model
{
    private final String ipAddress = "10.10.4.214:8000";
    private RequestQueue requestQueue;

    public Model(Context context)
    {
        requestQueue = Volley.newRequestQueue(context);
    }

    public boolean register(User user)
    {
        return false;
    }

    public int login(User user)
    {
        return -1;
    }

    public Event getEvent()
    {
        return null;
    }

    public ArrayList<Event> getEventList()
    {
        return new ArrayList<Event>();
    }
}
