package redis.client.CRUD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;

/**
 * SET,GET ở đây các key gắn value là Byte[] hoặc String.
 *
 */
public class App12_Get_Set_bytes {
	private static final Logger log = LogManager.getLogger();
	  

	public static void main(String[] args) {
		
		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 
		log.debug("Connection to server sucessfully"); 

		long value = 1000L*1000L;
		/**
		 * STEP 1: Create
		 * set(final byte[] key, final byte[] value)
 		 */

		jedis.set("keyBytes".getBytes(StandardCharsets.UTF_8), longToBytes(value)); //save (key, value) to HashMap

		/**
		 * STEP 2: read
		 */
		byte[] getValue = jedis.get("keyBytes".getBytes(StandardCharsets.UTF_8));
		log.debug("Get keyBytes = {} ", bytesToLong(getValue));  //get (key, value) from HashMap

	}

	public static byte[] longToBytes(long l) {
		byte[] result = new byte[Long.BYTES];
		for (int i = Long.BYTES - 1; i >= 0; i--) {
			result[i] = (byte)(l & 0xFF);
			l >>= Byte.SIZE;
		}
		return result;
	}

	public static long bytesToLong(final byte[] b) {
		long result = 0;
		for (int i = 0; i < Long.BYTES; i++) {
			result <<= Byte.SIZE;
			result |= (b[i] & 0xFF);
		}
		return result;
	}
}
