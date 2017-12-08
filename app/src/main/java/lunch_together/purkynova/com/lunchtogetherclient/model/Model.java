package lunch_together.purkynova.com.lunchtogetherclient.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;
import lunch_together.purkynova.com.lunchtogetherclient.representation.User;

/**
 * Created by vojtech on 12/8/17.
 */

public class Model
{
    public String register(String name, String mail, String password)
    {
        try
        {
            return new Register().execute(name,password,mail).get();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return "";
    }

    public int login(String name, String password)
    {
        try
        {
            return new Login().execute(name,password).get();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
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
