package redis.client;

import redis.clients.jedis.Jedis;

/**
 * SET,GET ở đây các key gắn value là Byte[] hoặc String.
 *
 */
public class App2_Get_Set {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("localhost"); //port default = 6379
		System.out.println("Connection to server sucessfully"); 

		jedis.set("tutorial-key", "value"); 

		System.out.println("Stored string in redis:: "+ jedis.get("tutorial-key"));

	}

}
