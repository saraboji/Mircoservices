package com.emirates.availabilityservices.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

public class AVLCacheKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object arg0, Method arg1, Object... arg2) {
		String cacheKey = StringUtils.arrayToCommaDelimitedString(arg2);
		return cacheKey;
	}

}
