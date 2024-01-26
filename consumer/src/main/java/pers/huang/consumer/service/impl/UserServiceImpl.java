package pers.huang.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.huang.consumer.model.entity.User;
import pers.huang.consumer.service.UserService;
import pers.huang.consumer.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-01-26 14:14:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




