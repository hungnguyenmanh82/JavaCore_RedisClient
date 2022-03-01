package redis.client.CRUD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
 * SET,GET ở đây các key gắn value là Byte[] hoặc String.
 *
 */

public class App22_Set_ExpireTime {

	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		
		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 
		log.debug("Connection to server sucessfully"); 
		
		//jedis.expire(key, seconds);
		jedis.set("tutorial-key", "value");
		jedis.expire("tutorial-key", 10); //10 second

		log.debug("Stored string in redis:: "+ jedis.get("tutorial-key"));

	}
}
