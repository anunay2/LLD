package DB;

import Model.Post;
import Model.User;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class InMemoryDB {

    public final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public static Map<Integer, User> userMap;
    public static Map<Integer, Post> postMap;
}
