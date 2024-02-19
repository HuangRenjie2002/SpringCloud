package pers.huang.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pers.huang.model.vo.UserVo;

@Component

public class TestListener {
    @RabbitListener(queues = "Queue")
    public void test(UserVo user) {
        System.out.println(user);
    }
}

