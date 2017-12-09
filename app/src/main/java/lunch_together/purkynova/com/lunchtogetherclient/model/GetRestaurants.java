package lunch_together.purkynova.com.lunchtogetherclient.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import lunch_together.purkynova.com.lunchtogetherclient.representation.Restaurant;

public class GetRestaurants extends AsyncTask<String, Void, JSONObject>
{
    @Override
    protected JSONObject doInBackground(String... params)
    {
        try
        {
            URL url = new URL("http://10.10.4.214:8000/api/get_rest");

            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
            outputStreamWriter.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line,result = "";
            while ((line = reader.readLine()) != null)
                stringBuilder.append(line + "\n");

            result = stringBuilder.toString();
            JSONObject json = new JSONObject(stringBuilder.toString());

            JSONArray restaurantsArr = json.getJSONArray("rest");
            for (int i = 0; i < restaurantsArr.length(); i++)
            {
                String id = restaurantsArr.getJSONObject(i).getString("restaurant_id");
                String restaurant = restaurantsArr.getJSONObject(i).getString("name_restaurant");
                String rating = restaurantsArr.getJSONObject(i).getJSONObject("rating").getString("aggregate_rating");
                String address = restaurantsArr.getJSONObject(i).getJSONObject("location").getString("address");
                String addr = address.substring(0,address.indexOf(","));
                String city = restaurantsArr.getJSONObject(i).getJSONObject("location").getString("city");
                String x = restaurantsArr.getJSONObject(i).getJSONObject("location").getString("latitude");
                String y = restaurantsArr.getJSONObject(i).getJSONObject("location").getString("longitude");

                
                Data.restaurants.add(new Restaurant(Integer.parseInt(id),restaurant,city + " " + addr,Float.parseFloat(x),Float.parseFloat(y), Float.parseFloat(rating)));
            }

            return json;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
