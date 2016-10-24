package com.emirates.availabilityservices.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CacheManagerCheck implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CacheManagerCheck.class);

    public static CacheManager cacheManager;

    @Autowired
    public CacheManagerCheck(CacheManager cacheManager1) {
        cacheManager = cacheManager1;
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("\n\n" + "=========================================================\n"
                + "Using cache manager: " + this.cacheManager.getClass().getName() + "\n"
                + "Cache : "+StringUtils.collectionToCommaDelimitedString(this.cacheManager.getCacheNames())
                + "=========================================================\n\n");
    }

}