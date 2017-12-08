package lunch_together.purkynova.com.lunchtogetherclient.representation;

/**
 * Created by lukkra on 8.12.17.
 */

public final class User {
    public final int id;
    public final String fullname;
    public final String mail;

    public User(int id, String fullname, String mail) {
        this.id = id;
        this.fullname = fullname;
        this.mail = mail;
    }
}
