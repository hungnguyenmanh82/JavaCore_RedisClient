package redis.client;

import redis.clients.jedis.Jedis;

/**
 * SET,GET ở đây các key gắn value là Byte[] hoặc String.
 *
 */
public class App2_Set_ExpireTime {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("localhost"); //port default = 6379
		System.out.println("Connection to server sucessfully"); 
		
//		   * @param nxxx NX|XX, NX -- Only set the key if it does not already exist. XX -- Only set the key
//		   *          if it already exist.
//		   * @param expx EX|PX, expire time units: EX = seconds; PX = milliseconds
//		jedis.set("tutorial-key", "value","XX","EX",10); // = 10s expire 
		

		
		//jedis.expire(key, seconds);
		jedis.set("tutorial-key", "value");
		jedis.expire("tutorial-key", 10); //10 second

		System.out.println("Stored string in redis:: "+ jedis.get("tutorial-key"));

	}

}
