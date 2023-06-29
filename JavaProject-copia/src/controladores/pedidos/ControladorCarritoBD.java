package controladores.pedidos;

import controladores.Connect;
import controladores.producto.ControladorProductos;
import controladores.producto.ControladorProductosBD;
import controladores.views.ClienteViewController;
import modelo.pedidos.Carrito;
import modelo.pedidos.Item;
import modelo.producto.Producto;
import modelo.usuario.Usuario;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.resps.Tuple;

import java.util.ArrayList;
import java.util.List;


public class ControladorCarritoBD {

    public static void addToCarrito(Usuario user, Item prod){
        JedisPooled jedis = new JedisPooled("redis://TPO-BDO2:Pepe123!@redis-12191.c281.us-east-1-2.ec2.cloud.redislabs.com:12191");

        String dni = Integer.toString(user.getDni());

        jedis.zadd(dni,prod.getCantidad(), prod.getProducto().getNombre());

        jedis.expire(dni,259200);

        jedis.close();
    }

    public static Carrito getCarrito(Usuario usuario){

        JedisPooled jedis = new JedisPooled("redis://TPO-BDO2:Pepe123!@redis-12191.c281.us-east-1-2.ec2.cloud.redislabs.com:12191");

        String key = Integer.toString(usuario.getDni());

        List<Tuple> carritoRedis = jedis.zrangeByScoreWithScores(key, 0, 100000);

        List<Item> items = new ArrayList<>();


        for (Tuple tuple : carritoRedis){
            Producto producto = ControladorProductosBD.getProductByName(tuple.getElement());
            Item item = new Item(producto, (int)tuple.getScore());
            items.add(item);
        }

        jedis.close();

        return new Carrito(items, ClienteViewController.getCliente());
    }

    public static void removeCarrito(){

        JedisPooled jedis = new JedisPooled("redis://TPO-BDO2:Pepe123!@redis-12191.c281.us-east-1-2.ec2.cloud.redislabs.com:12191");

        String key = Integer.toString(ClienteViewController.getCliente().getDni());

        jedis.del(key);

        jedis.close();
    }


    public static void removeItemCarrito(String producto){
        JedisPooled jedis = new JedisPooled("redis://TPO-BDO2:Pepe123!@redis-12191.c281.us-east-1-2.ec2.cloud.redislabs.com:12191");

        String key = Integer.toString(ClienteViewController.getCliente().getDni());

        jedis.zrem(key,producto);

        jedis.close();
    }




}
