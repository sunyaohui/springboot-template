package com.thyme.sun.config;

import java.util.HashMap;
import java.util.Map;

import com.thyme.sun.cache.SwaggerCache;

public class YmlConfigStore {
	
	public Map<String, Object> map = new HashMap<>();

	public static <T> T get(String key,Class<?> clazz){
		return SwaggerCache.get(key, clazz);
	}

}
