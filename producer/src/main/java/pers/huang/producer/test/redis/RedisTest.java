package pers.huang.producer.test.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.huang.utils.RedisUtil;

import java.time.LocalDateTime;
import java.util.Date;


@SpringBootTest
public class RedisTest {
    @Autowired
    RedisUtil redisUtil;
    @Test
    public void redisString(){
        redisUtil.set("a", new Date());
        Object a = redisUtil.get("a");
        System.out.println(a);
    }


}
