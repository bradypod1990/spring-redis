package com.feng.test;

import java.util.Collections;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

public class RedisRun implements Runnable{

	private RedisTemplate redisTemplate;
	public RedisRun(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			StringBuffer sb = new StringBuffer();
	        sb.append("local ygmed=redis.call('hget',KEYS[1],'ygmed'); local oldygmed = ygmed;")
	                .append("local cped=redis.call('hget',KEYS[1],'cped');")
	                .append("if  tonumber(ygmed)>=tonumber(cped) then  return '';")
	                .append("else ygmed=ygmed+ARGV[1];")
	                .append("redis.call('hset',KEYS[1],'ygmed',ygmed); local newygmed=redis.call('hget',KEYS[1],'ygmed');")
	                .append("return oldygmed..'----'..newygmed; end");
			  
			  final DefaultRedisScript rs = new DefaultRedisScript();
			  rs.setScriptText(sb.toString());
			  rs.setResultType(String.class);
			Object d = redisTemplate.execute(rs, Collections.singletonList("A0D018"), "500");
			System.out.println(i + "-----------------------" + d);
		}
	}

}
