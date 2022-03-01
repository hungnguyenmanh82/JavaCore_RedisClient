package redis.client.CRUD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
 * SET,GET ở đây các key gắn value là Byte[] hoặc String.
 */
public class App11_Get_Set_String {
    private static final Logger log = LogManager.getLogger();


    public static void main(String[] args) {

        String address = "localhost";
        int port = 6379; //default Port = 6379

        Jedis jedis = new Jedis(address, port);
        log.debug("Connection to server sucessfully");

        jedis.set("tutorial-key", "value"); //save (key, value) to HashMap

        log.debug("Stored string in redis:: " + jedis.get("tutorial-key"));  //get (key, value) from HashMap

    }

}
