package controladores;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.resps.Tuple;

import java.io.PrintStream;
import java.util.List;

public class Connect {

    private static final String STRINGCONNECTION = "mongodb+srv://usuarioTPO:usuarioTPO1234@test.72xjhue.mongodb.net/";


    public Connect(){
    }
    public MongoClient startMongo(){
        try (MongoClient mongoClient = MongoClients.create(STRINGCONNECTION)) {
            System.out.println("Connection succesfull");
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



        jedis.zadd("44338275", 1, "RTX2060");
        jedis.zadd("44338275", 3, "RTX2080");
        List<Tuple> carrito = jedis.zrangeByScoreWithScores("44338275", 0, 100000);

        for(Tuple tuple : carrito){

            System.out.println(tuple.getElement() + "-" + tuple.getScore());

        }





    }
}
