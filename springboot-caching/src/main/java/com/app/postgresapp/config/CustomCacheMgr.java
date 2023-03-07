package com.app.postgresapp.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomCacheMgr {

    @Bean
    CacheManagerCustomizer<ConcurrentMapCacheManager> customCacheManager() {
        return new CacheMgr();
    }

    static class CacheMgr implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(false);
            cacheManager.setStoreByValue(true);
            System.out.println("Customizer Invoked!!");
        }
    }
}
