package redis.client.CRUD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

public class App1_connect {
	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {

		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 

		log.debug("Connection to server sucessfully"); 
		//check whether server is running or not 
		log.debug("Server is running: "+jedis.ping()); 

	}

}
