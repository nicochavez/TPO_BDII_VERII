package controladores;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;

public class Connect {

    private final String STRINGCONNECTION = "mongodb+srv://ramirofarfanuk:<password>@test.72xjhue.mongodb.net/";


    public Connect(){
    }
    public MongoClient startMongo(){
        try (MongoClient mongoClient = MongoClients.create(STRINGCONNECTION)) {
            System.out.println("Connection succesfully");
            return mongoClient;
        } catch (Exception e){
            System.out.println("Connection refused");
            return null;
        }
    }

    public static JedisPooled startRedis() {
        JedisPooled jedis = new JedisPooled("redis://TPO-BDO2:Pepe123!@redis-12191.c281.us-east-1-2.ec2.cloud.redislabs.com:12191");
        return jedis;
    }


    public static void main(String[] args) {

        JedisPooled jedis = startRedis();
        jedis.set("foo", "bar");
        System.out.println(jedis.get("foo"));


    }
}
