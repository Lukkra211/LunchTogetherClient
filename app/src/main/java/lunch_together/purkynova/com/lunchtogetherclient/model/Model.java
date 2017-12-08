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

import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;

/**
 * Created by vojtech on 12/8/17.
 */

public abstract class Client
{
    private final String serverURL = "10.10.5.209";
    private RequestQueue requestQueue;


    public void init(Context context)
    {
        requestQueue = Volley.newRequestQueue(context);
    }

    //return true/false
    public boolean register(String name, String email, String password)
    {
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(serverURL+"/request", new JSONObject(), future, future);
        requestQueue.add(request);

        try
        {
            JSONObject response = future.get();
            //Parse JSON
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
    }

    //return id
    public int login()
    {
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(serverURL+"/login", new JSONObject(), future, future);
        requestQueue.add(request);

        try
        {
            JSONObject response = future.get();
            //Parse JSON
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return -1;
    }

    public Event getUsersEvent()
    {
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(serverURL+"/getUsersEvent", new JSONObject(), future, future);
        requestQueue.add(request);

        try
        {
            JSONObject response = future.get();
            //Parse JSON
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    public Event getAllEvents()
    {
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(serverURL+"/getAllEvents", new JSONObject(), future, future);
        requestQueue.add(request);

        try
        {
            JSONObject response = future.get();
            //Parse JSON
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

}
