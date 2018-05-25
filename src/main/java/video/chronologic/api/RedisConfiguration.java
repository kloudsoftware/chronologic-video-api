package video.chronologic.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import video.chronologic.api.dto.Video;

@Configuration
public class RedisConfiguration {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Video> redisTemplate() {
        RedisTemplate<String, Video> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
}