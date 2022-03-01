package redis.client.CRUD;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
 * Hiển thị tất cả các keys mà các client đăng ký với server
 *
 */
public class App3_ShowKeys {
	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 

		log.debug("Connection to server sucessfully"); 

		Set<String> set =  jedis.keys("*"); 

		System.out.println("====================== list of keys in Redis server:");
		for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
			String st = it.next();

			log.debug(st);
		}
	}

}
