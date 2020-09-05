package com.github.enesusta.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public final class DefaultRedisInstance implements RedisInstance<Jedis> {

    private final RedisConfiguration redisConfiguration;

    public DefaultRedisInstance(final RedisConfiguration redisConfiguration) {
        this.redisConfiguration = redisConfiguration;
    }

    @Override
    public Jedis getRedisInstance() {
        final JedisShardInfo shardInfo = new JedisShardInfo(redisConfiguration.getHost(), redisConfiguration.getPort());
        shardInfo.setPassword(redisConfiguration.getPassword());
        shardInfo.setConnectionTimeout(redisConfiguration.getTimeout());

        return new Jedis(shardInfo);
    }
}
