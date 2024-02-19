package pers.huang.producer.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.huang.model.vo.RestVo;
import pers.huang.model.vo.UserVo;
import pers.huang.utils.RedisUtil;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/rabbitmq")
    public RestVo rabbitmq() {
        String user1 = redisUtil.get("user1");
        UserVo userVo = JSONObject.parseObject(user1, UserVo.class);
        BeanUtils.copyProperties(user1,userVo);
        rabbitTemplate.convertAndSend("Exchange", "test", userVo);
        return RestVo.successVo();
    }
}
