package redis.client.transaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * https://www.javatpoint.com/redis-transaction
 */
public class App1_transaction {
    private static final Logger log = LogManager.getLogger();


    public static void main(String[] args) {

        String address = "localhost";
        int port = 6379; //default Port = 6379

        Jedis jedis = new Jedis(address, port);

        log.debug("Connection to server sucessfully");
        // STEP 1: start transaction
        Transaction transaction = jedis.multi();

        transaction.set("keyA", "valueA");
        transaction.set("keyB", "valueB");

        /**
         * STEP 2: commit transaction
         * results sẽ chứa kết quả thành công hay fail
         */
        List<Object> results = transaction.exec();

        log.debug("results = {}", results);
    }

}
