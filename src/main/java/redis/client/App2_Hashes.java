package redis.client;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * SET,GET ở đây các key gắn value là Byte[] hoặc String.
 *
 */
public class App2_Hashes {

	public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost"); //port default = 6379
		System.out.println("Connection to server sucessfully"); 

		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("key1", "value1");
		myMap.put("key2", "value2");
		myMap.put("key3", "value3");
		myMap.put("key4", "value4");
		jedis.hmset("keyMap", myMap);

		Map<String, String> myMap2;
		System.out.println("Stored string in redis:: "+ jedis.hmget("keyMap", "key1"));
		System.out.println("Stored string in redis:: "+ jedis.hmget("keyMap", "key2"));

	}

}
