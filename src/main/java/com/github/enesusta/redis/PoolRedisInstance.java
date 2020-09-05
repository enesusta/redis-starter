package com.github.enesusta.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

public class PoolRedisInstance implements RedisInstance<JedisPool> {

    private final RedisConfiguration redisConfiguration;

    public PoolRedisInstance(final RedisConfiguration redisConfiguration) {
        this.redisConfiguration = redisConfiguration;
    }

    @Override
    public JedisPool getRedisInstance() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        poolConfig.setMaxIdle(128);
        poolConfig.setMinIdle(16);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
        poolConfig.setNumTestsPerEvictionRun(3);
        poolConfig.setBlockWhenExhausted(true);

        final String host = redisConfiguration.getHost();
        final int port = redisConfiguration.getPort();
        final int timeout = redisConfiguration.getTimeout();
        final String password = redisConfiguration.getPassword();

        final JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout, password);

        return jedisPool;
    }
}
