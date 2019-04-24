package redis.client;

import redis.clients.jedis.Jedis;

/**
 https://www.javatpoint.com/redis-installation
Redis = Remote Dictionary Server. 
Mục đích: để cache (lưu) dữ liệu trên RAM và dùng lại nhằm tăng performance khi đọc dữ liệu. Dùng cho những dữ liệu đc dùng thường xuyên. 
Redis gồm 2 phần: Server + Client
Redis server= 1 TCP server + memory cache (RAM) HashMap.

 Redis server ko phải là Http server. 
 Ta ko lập trình với Redis server mà chỉ config cho nó giống như Tomcat: vd: user, pass, port, số connect cho phép, default expire time…
Redis lưu giữ liệu trên RAM dùng HashMap với cặp (key, value). 
Từ Redis Client ta sẽ connect tơi redis server để thực hiện các thao tác CRUD với cặp (key,value).
Vai trò chính của nó là Dictionary để search, mà nó ko tổ chức theo table nên gọi là No-SQL.

 */
public class App2_Delete {

	public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost"); //port default = 6379
		System.out.println("Connection to server sucessfully"); 

		jedis.del("tutorial-key");  // hashmap (key, value)

		System.out.println("Stored string in redis:: "+ jedis.get("tutorial-key"));

	}

}
