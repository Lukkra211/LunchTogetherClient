package lunch_together.purkynova.com.lunchtogetherclient.model;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by vojtech on 12/9/17.
 */

public class CreateEvent extends AsyncTask<String, Integer, Integer>
{
    @Override
    protected Integer doInBackground(String... params)
    {
        try
        {
            String data = "&" + URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8");
            data += "&" + URLEncoder.encode("tag", "UTF-8") + "=" + URLEncoder.encode(params[1], "UTF-8");
            data += "&" + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(params[2], "UTF-8");
            data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(params[3], "UTF-8");
            data += "&" + URLEncoder.encode("note", "UTF-8") + "=" + URLEncoder.encode(params[4], "UTF-8");

            URL url = new URL("http://10.10.4.214:8000/api/create_event");

            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
            outputStreamWriter.write(data);
            outputStreamWriter.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line,result = "";
            while ((line = reader.readLine()) != null)
                stringBuilder.append(line + "\n");

            result = stringBuilder.toString();
            JSONObject json = new JSONObject(stringBuilder.toString());
            return Integer.parseInt(json.getString("event_id"));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
}
