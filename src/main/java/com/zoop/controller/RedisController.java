package com.zoop.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("/redis")
public class RedisController {

	private static final Logger logger = Logger.getLogger(RedisController.class);
	
	@Autowired
	private JedisPool jedisPool;
	
	@RequestMapping(value="/get")
	@ResponseBody
	public String get(@RequestParam(value="key") String key) {
		try {
			Jedis jedis = jedisPool.getResource();
			String value = jedis.get(key);
			logger.info("value:::::::::::::"+value);
			return value;
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
	
}
