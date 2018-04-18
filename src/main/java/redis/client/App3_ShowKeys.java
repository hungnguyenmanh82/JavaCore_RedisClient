package redis.client;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Hiển thị tất cả các keys mà các client đăng ký với server
 *
 */
public class App3_ShowKeys {

	public static void main(String[] args) {
		//Connecting to Redis server on localhost 
		Jedis jedis = new Jedis("localhost"); 
		System.out.println("Connection to server sucessfully"); 

		Set<String> set =  jedis.keys("*"); 

		for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
			String st = it.next();

			System.out.println(st);
		}
	}

}
