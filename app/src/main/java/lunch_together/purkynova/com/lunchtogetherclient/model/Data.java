package lunch_together.purkynova.com.lunchtogetherclient.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import lunch_together.purkynova.com.lunchtogetherclient.representation.Event;
import lunch_together.purkynova.com.lunchtogetherclient.representation.Restaurant;
import lunch_together.purkynova.com.lunchtogetherclient.representation.User;

/**
 * Created by vojtech on 12/8/17.
 */

public class Data
{
    public static ArrayList<Event> events = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static int activeEvent = -1;
    public static int userID;

    public Data(JSONObject response)
    {
        try
        {
            JSONArray jsonEvents = response.getJSONArray("events");
            JSONArray jsonUsers = response.getJSONArray("users");
            userID = response.getInt("user_belongs_to");

            for(int i = 0; i < jsonUsers.length(); i++)
            {
                String userID = jsonUsers.getJSONObject(i).getString("user_id");
                String name = jsonUsers.getJSONObject(i).getString("name");
                String mail = jsonUsers.getJSONObject(i).getString("mail");
                String eventID = jsonUsers.getJSONObject(i).getString("event");

                User user = new User(Integer.parseInt(userID),name,mail,Integer.parseInt(eventID));
                users.add(user);
            }

            for(int i = 0; i < jsonEvents.length(); i++)
            {
                String id = jsonEvents.getJSONObject(i).getString("id");
                String time = jsonEvents.getJSONObject(i).getString("time");
                String name = jsonEvents.getJSONObject(i).getString("name");
                String note = jsonEvents.getJSONObject(i).getString("note");


                Restaurant restaurant = null;
                try {
                    JSONObject jsonRestaurant = jsonEvents.getJSONObject(i).getJSONObject("restaurant");

                    String restaurant_id = jsonRestaurant.getString("restaurant_id");
                    String name_restaurant = jsonRestaurant.getString("name_restaurant");
                    String menu = jsonRestaurant.getString("menu");
                    Float rating = Float.parseFloat(jsonRestaurant.getJSONObject("rating").getString("aggregate_rating"));

                    String address = jsonRestaurant.getJSONObject("location").getString("address");
                    String city = jsonRestaurant.getJSONObject("location").getString("city");

                    String addr = address.substring(0,address.indexOf(","));

                    restaurant = new Restaurant(Integer.parseInt(restaurant_id),name_restaurant,city + " " + addr,menu,rating);
                } catch (Exception e) {}

                ArrayList<User> eventUsers = new ArrayList<>();

                for (int j = 0; j < users.size() ; j++)
                {
                    if (users.get(j).eventID == Integer.parseInt(id))
                    {
                        eventUsers.add(users.get(j));
                    }
                }

                Event event = new Event(Integer.parseInt(id),name,eventUsers, time,note,restaurant);
                events.add(event);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
