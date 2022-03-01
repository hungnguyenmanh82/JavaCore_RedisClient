package redis.client.pubsub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Hiển thị tất cả các keys mà các client đăng ký với server
 *
 */
public class App21_publisher {
	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 

		log.debug("Connection to server sucessfully");

		String channel = "channel-1";

		/**
		 * nếu có 1 subscriber thì result = 1
		 * nếu có 2 subscriber thì result = 2
		 */
		long result = jedis.publish(channel, "message 1");

		log.debug("publish result = {}", result);
	}

}
