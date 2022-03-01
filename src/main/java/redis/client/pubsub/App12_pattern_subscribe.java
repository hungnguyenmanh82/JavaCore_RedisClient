package redis.client.pubsub;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Hiển thị tất cả các keys mà các client đăng ký với server
 *
 */
public class App12_pattern_subscribe {
	private static final Logger log = LogManager.getLogger();
	public static void main(String[] args) {
		String address = "localhost";
		int port = 6379; //default Port = 6379

		Jedis jedis = new Jedis(address,port); 

		log.debug("Connection to server sucessfully"); 

		/**
		 * Subscribe chia làm 2 nhóm: Pattern và ko dùng Pattern (giống với Kafka)
		 * Lý ra ở thư viện nó phải tách 2 nhóm này ra. vì nó ko liên quan tới nhau
		 */
		JedisPubSub jedisPubSub_callback = new JedisPubSub() {

			 // ======================================== Nhóm ko dùng Pattern  ====================================
			@Override
			public void onMessage(String channel, String message) {
				log.debug("====== onMessage():  channel = {}, message={}", channel, message);
			}

			@Override
			public void onSubscribe(String channel, int subscribedChannels) {
				log.debug("====== onSubscribe():  channel = {}, subscribedChannels={}", channel, subscribedChannels);
			}

			@Override
			public void onUnsubscribe(String channel, int subscribedChannels) {
				log.debug("====== onUnsubscribe():  channel = {}, subscribedChannels={}", channel, subscribedChannels);
			}
            // ======================================== Nhóm Pattern ====================================
			@Override
			public void onPMessage(String pattern, String channel, String message) {
				// PMessage = Pattern Message
				log.debug("====== onPMessage(): pattern = {}, channel = {}, message={}", pattern, channel, message);
			}
			
			@Override
			public void onPUnsubscribe(String pattern, int subscribedChannels) {
				// PUnsubscrib = Pattern unSubscribe
				log.debug("====== onPUnsubscribe(): pattern = {}, subscribedChannels = {}", pattern, subscribedChannels);
			}

			@Override
			public void onPSubscribe(String pattern, int subscribedChannels) {
				// PUnsubscrib = Pattern unSubscribe
				super.onPSubscribe(pattern, subscribedChannels);
			}

			@Override
			public void onPong(String pattern) {
				log.debug("======= onPong(): pattern = {}", pattern);
			}
			
		};
		
		String channel = "channel-1";
		jedis.subscribe(jedisPubSub_callback, channel);
		
//		jedisPubSub_callback.unsubscribe();
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error("error: ", e); 
			}
		}
	}

}
