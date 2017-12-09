package lunch_together.purkynova.com.lunchtogetherclient.representation;

/**
 * Created by vojtech on 12/9/17.
 */

public class Restaurant
{
    public final int id;
    public final String name;
    public final String location;
    public final String menu;
    public final float rating;
    public final float x;
    public final float y;

    public Restaurant(int id, String name, String location,String menu, float rating, float x, float y) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.menu = menu;
        this.rating = rating;
        this.x = x;
        this.y = y;
    }
}
