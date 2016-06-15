package com.feng.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.Cacheable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import com.feng.dao.UserDao;
import com.feng.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = { "classpath:spring-redisCluster.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class RedisClusterTest {

	private static final int List = 0;
	

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void test1() {
		List<User> list = userDao.getAll();

		if (list != null) {
			for (User u : list) {
				System.out.println(u.getName() + "----" + u.getPassword());
			}
		}
	}


	@Test
	public void test2() {
		List<User> list = userDao.getByName("zoufeng13");

		if (list != null) {
			for (User u : list) {
				System.out.println(u.getName() + "----" + u.getPassword());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testCluster() {
		final String keyf = "zoufeng2";
		final String valuef = "zoufeng2";
		 redisTemplate.execute(new RedisCallback<Long>() {  
	            public Long doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                byte[] keyb = keyf.getBytes();  
	                byte[] valueb = toByteArray(valuef);  
	                connection.set(keyb, valueb);  
	                return 1L;  
	            }  
	        });  
		 
		 
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void addQdcp() {
		 redisTemplate.execute(new RedisCallback<Long>() {  
	            public Long doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                byte[] keyb = "A0D018".getBytes();  
//	                byte[] valueb = toByteArray(valuef);  
	                Map<byte[], byte[]> map = new HashMap<byte[], byte[]>();
	                map.put("cpdm".getBytes(), "A0D018".getBytes());
	                map.put("ygmed".getBytes(), "0".getBytes());
	                map.put("cped".getBytes(), "100000".getBytes());
	                connection.hMSet(keyb, map);
	                return 1L;  
	            }  
	        });  
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void setValue() {
		 
//        Object d = redisTemplate.execute(rs, Collections.singletonList("A0D018"), "1000");
//         System.out.println(d);
		ExecutorService es = Executors.newFixedThreadPool(20);
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
		es.execute(new Thread(new RedisRun(redisTemplate)));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		es.execute(new Thread(r));
//		for(int i=0; i<20; i++) {
//			new Thread(new RedisRun(redisTemplate)).run();
//		}
	}
	
	@Test
	public void testConnectRedis() {
		JedisPool jedisPool = null;
		int lxfwxzsj = 0; // 连续访问限制时间（ms）
		String quota_name = ""; // 抢单队列名称
		if (jedisPool == null) {
			JedisPoolConfig config = new JedisPoolConfig();
//			config.setMaxTotal(Integer.parseInt(appConfig
//					.getProperty("REDIS_MAXTOTAL")));
//			config.setMinIdle(Integer.parseInt(appConfig
//					.getProperty("REDIS_MINIDLE")));
//			config.setMaxWaitMillis(Long.parseLong(appConfig
//					.getProperty("REDIS_MAX_WAIT_MILLIS")));
//			config.setTestOnBorrow(Boolean.parseBoolean(appConfig
//					.getProperty("REDIS_TESTBORROW")));
			jedisPool = new JedisPool(config,"127.0.0.1",6379,Protocol.DEFAULT_DATABASE,"apexsoft");
		}

	}
	
	 private byte[] toByteArray(Object obj) {  
	        byte[] bytes = null;  
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	        try {  
	            ObjectOutputStream oos = new ObjectOutputStream(bos);  
	            oos.writeObject(obj);  
	            oos.flush();  
	            bytes = bos.toByteArray();  
	            oos.close();  
	            bos.close();  
	        } catch (IOException ex) {  
	            ex.printStackTrace();  
	        }  
	        return bytes;  
	    }
	 
	 @Test
	 public void testAnnotation() {
		 Map<String, Object> map = applicationContext.getBeansWithAnnotation(Cacheable.class);
		 System.out.println(map);
	 }
}
