
## Install

```xml
<dependency>
  <groupId>com.github.enesusta</groupId>
  <artifactId>redis-starter</artifactId>
  <version>1.0.1</version>
</dependency>
```


Example:

```java
import com.github.enesusta.redis.PoolRedisInstance;
import com.github.enesusta.redis.RedisConfiguration;
import com.github.enesusta.redis.RedisInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisPoolConfiguration {

    @Value("${spring.redis.jedis.password}")
    private String password;

    @Bean
    public JedisPool jedisPool() {
        final RedisConfiguration redisConfiguration = new RedisConfiguration.Builder(password)
                .host("localhost")
                .port(6379)
                .build();

        final RedisInstance<JedisPool> jedisPoolRedisInstance = new PoolRedisInstance(redisConfiguration);
        return jedisPoolRedisInstance.getRedisInstance();
    }

}
```