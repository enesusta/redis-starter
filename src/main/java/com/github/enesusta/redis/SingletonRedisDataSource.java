package com.github.enesusta.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public final class SingletonRedisDataSource implements RedisDataSource<Jedis> {

    private final RedisConfiguration redisConfiguration;

    public SingletonRedisDataSource(final RedisConfiguration redisConfiguration) {
        this.redisConfiguration = redisConfiguration;
    }

    @Override
    public Jedis getRedisDataSource() {

        final JedisShardInfo shardInfo = new JedisShardInfo(redisConfiguration.getHost(), redisConfiguration.getPort());
        shardInfo.setPassword(redisConfiguration.getPassword());
        shardInfo.setConnectionTimeout(redisConfiguration.getTimeout());

        return new Jedis(shardInfo);
    }
}
