package pers.huang.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.huang.model.vo.RestVo;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    public RestVo get(){
        return RestVo.successVo();
    }
}
