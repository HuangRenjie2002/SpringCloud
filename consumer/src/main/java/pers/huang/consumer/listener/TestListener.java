package pers.huang.consumer.listener;

import com.alibaba.fastjson2.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import pers.huang.model.vo.UserVo;

import java.io.IOException;

@Configuration
public class TestListener {
    @RabbitListener(queues = "Queue")
    public void test(Message msg, Channel channel) throws IOException {
        byte[] body = msg.getBody();
        UserVo userVo = JSONObject.parseObject(new String(body), UserVo.class);
        System.out.println(userVo);
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(),true);
    }
}

