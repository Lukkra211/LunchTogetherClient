package lunch_together.purkynova.com.lunchtogetherclient.model;

import org.json.JSONObject;

import java.util.ArrayList;

import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;
import lunch_together.purkynova.com.lunchtogetherclient.representation.User;

/**
 * Created by vojtech on 12/8/17.
 */

public class Model
{
    public static Data data = null;

    public static String register(String name, String mail, String password)
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

    public static int login(String name, String password)
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

    public void initializeData(String userID)
    {
        try
        {
            JSONObject response = new GetEvents().execute(userID).get();
            this.data = new Data(response);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void joinEvent(String userID, String eventID)
    {

    }

    public void leaveEvent(String userID)
    {

    }

}
