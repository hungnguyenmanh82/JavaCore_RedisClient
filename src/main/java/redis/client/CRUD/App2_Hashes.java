package redis.client.CRUD;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
 * SET,GET ở đây các key gắn value là Byte[] hoặc String.
 *
 */
public class App2_Hashes {
	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) {

		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 
		log.debug("Connection to server sucessfully"); 

		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("key1", "value1");
		myMap.put("key2", "value2");
		myMap.put("key3", "value3");
		myMap.put("key4", "value4");
		jedis.hmset("keyMap", myMap);

		Map<String, String> myMap2;
		log.debug("Stored string in redis:: "+ jedis.hmget("keyMap", "key1"));
		log.debug("Stored string in redis:: "+ jedis.hmget("keyMap", "key2"));

	}

}
