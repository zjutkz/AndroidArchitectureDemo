package zjutkz.com.mvp.model;

/**
 * Created by kangzhe on 16/4/7.
 */
public class Contributor {

    public String login;
    public int contributions;

    @Override
    public String toString() {
        return login + ", " + contributions;
    }
}
