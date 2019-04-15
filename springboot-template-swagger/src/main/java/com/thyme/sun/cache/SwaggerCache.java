package com.thyme.sun.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.thyme.sun.config.YmlConfigStore;
import com.thyme.sun.util.YmlUtil;

public class SwaggerCache {
	
	public static final Map<String, YmlConfigStore> ymlConfigLocalCache = new ConcurrentHashMap<String, YmlConfigStore>();

	public static void set(String key,YmlConfigStore ymlConfigStore){
		ymlConfigLocalCache.put("ymlConfigStore", ymlConfigStore);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T get(String key,Class<?> clazz){
		YmlConfigStore ymlConfigStore = ymlConfigLocalCache.get("ymlConfigStore");
		if(ymlConfigStore==null){
				YmlConfigStore yml = new YmlConfigStore();
				yml.map.put(key, YmlUtil.getValue(key, clazz));
				ymlConfigLocalCache.put("ymlConfigStore", yml);
				return (T)yml.map.get(key);
		}else{
			if(ymlConfigStore.map.containsKey(key)) {
				return (T)ymlConfigStore.map.get(key);
			}
			ymlConfigStore.map.put(key, YmlUtil.getValue(key, clazz));
			ymlConfigLocalCache.put("ymlConfigStore", ymlConfigStore);
			return (T)ymlConfigStore.map.get(key);
		}
	}

}
