package pers.huang.consumer.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.huang.consumer.model.entity.User;
import pers.huang.consumer.service.UserService;
import pers.huang.model.vo.RestVo;
import pers.huang.model.vo.UserVo;
import pers.huang.utils.RedisUtil;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/info")
    public RestVo get(@RequestParam("id") Integer id) {
        User user = userService.getById(id);
        return RestVo.successVo(user);
    }

    @GetMapping("/redis")
    public RestVo redis() {
        for (int i = 1; i <= 10; i++) {
            User user = userService.getById(i);
            String jsonString = JSONObject.toJSONString(user);
            redisUtil.set("user" + i, jsonString);
        }
        return RestVo.successVo();
    }

    @GetMapping("/rabbitmq")
    public RestVo rabbitmq() {
        User user = userService.getById(1);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        rabbitTemplate.convertAndSend("Exchange", "test", userVo);
        return RestVo.successVo();
    }
}
