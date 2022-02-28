package redis.client;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

/**
 * ở đây Key gắn với 1 List
 *
 */
public class App3_List {
	private static Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 
		log.debug("Connection to server sucessfully"); 

		//store data in redis list 
		jedis.lpush("tutorial-list", "Redis"); 
		jedis.lpush("tutorial-list", "Mongodb"); 
		jedis.lpush("tutorial-list", "Mysql"); 

		// Get the stored data and print it 
		List<String> list = jedis.lrange("tutorial-list", 0 ,5); 

		for(int i = 0; i<list.size(); i++) { 
			log.debug("Stored string in redis:: "+list.get(i)); 
		} 
	}

}
