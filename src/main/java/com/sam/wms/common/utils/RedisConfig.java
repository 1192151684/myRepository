/*
package com.sam.wms.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;

*/
/**
 * @author name:RedisConfig
 * date:2021.02.2021/2/25
 * time:2:00
 *//*


@Configuration
//开启缓存

public class RedisConfig {

    @Autowired
    private RedisConnectionFactory factory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 配置连接工厂
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    */
/**
     * 对hash类型的数据操作
     * @param redisTemplate
     * @return
     *//*

    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    */
/**
     * 对redis字符串类型数据操作
     * @param redisTemplate
     * @return
     *//*

    @Bean
    public ValueOperations<String, String> valueOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    */
/**
     * 对链表类型的数据操作
     * @param redisTemplate
     * @return
     *//*

    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    */
/**
     * 对无序集合类型的数据操作
     * @param redisTemplate
     * @return
     *//*

    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    */
/**
     * 对有序集合类型的数据操
     * @param redisTemplate
     * @return
     *//*

    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }

}
*/
