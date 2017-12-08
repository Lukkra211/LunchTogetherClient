package lunch_together.purkynova.com.lunchtogetherclient.model;

import java.util.ArrayList;

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
        ArrayList<Event> test = new ArrayList<Event>();
        try {
            test.add(new Event("První", new ArrayList<User>(), "2017-12-09 12:00", "Purkuňova 1990"));
            test.add(new Event("Druhá", new ArrayList<User>(), "2017-12-09 12:00", "Měsíc 100"));
            test.add(new Event("Třetí", new ArrayList<User>(), "2017-12-09 12:00", "Na nádraží"));
            test.add(new Event("Čtvrtá", new ArrayList<User>(), "2017-12-09 12:00", "Na hřbitově"));
        } catch (Exception e) {

        }


        return test;
    }
}
