package redis.client.CRUD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;

<<<<<<<< HEAD:src/main/java/redis/client/CRUD/App0_connect.java
public class App0_connect {
========
public class App1_connect {
>>>>>>>> origin/master:src/main/java/redis/client/CRUD/App1_connect.java
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
