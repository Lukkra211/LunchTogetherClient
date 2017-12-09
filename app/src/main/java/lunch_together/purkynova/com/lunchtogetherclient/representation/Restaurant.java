package lunch_together.purkynova.com.lunchtogetherclient.representation;

/**
 * Created by vojtech on 12/9/17.
 */

public class Restaurant
{
    public final int id;
    public final String name;
    public final String location;
    public final float x = 0;
    public final float y = 0;
    public final float rating;

    public Restaurant(int id, String name, String location, float x, float y, float rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
    }
}
