package com.mcrouter.app.configs;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Configuration
public class MemCachierConfig {

    @Bean
    public MemcachedClient defaultMemcachedClient() {
        String serverString = System.getenv("MEMCACHIER_SERVER").replace(",", " ");

        try {
            return new MemcachedClient(
                    new ConnectionFactoryBuilder()
                            .setProtocol(ConnectionFactoryBuilder.Protocol.BINARY)
                            .build(),
                    AddrUtil.getAddresses(serverString));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}