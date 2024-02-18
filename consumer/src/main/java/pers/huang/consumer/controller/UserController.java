package pers.huang.consumer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.huang.consumer.model.entity.User;
import pers.huang.consumer.service.UserService;
import pers.huang.model.vo.RestVo;
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
    public RestVo get(@RequestParam("id") Integer id){
        User user = userService.getById(id);
        return RestVo.successVo(user);
    }

    @GetMapping("/redis")
    public RestVo redis(){
        User user = userService.getById(1);
        redisUtil.hashPut("user","age",5);
//redisUtil.set("user","454");
        Object a = redisUtil.hashGet("user", "age");
//        Object a = redisUtil.get("user");
        return RestVo.successVo(a);
    }

    @GetMapping("/rabbitmq")
    public RestVo rabbitmq(){
        User user = userService.getById(1);
        rabbitTemplate.convertAndSend("Exchange","test",user);
        return RestVo.successVo();
    }
}
