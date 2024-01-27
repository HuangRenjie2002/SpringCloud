package pers.huang.consumer.controller;

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

    @GetMapping("/info")
    public RestVo get(@RequestParam("id") Integer id){
        User user = userService.getById(id);
        return RestVo.successVo(user);
    }

    @GetMapping("/redis")
    public RestVo redis(){
        User user = userService.getById(1);
redisUtil.set("user",user);
        Object a = redisUtil.get("user");
        return RestVo.successVo(a);
    }
}
