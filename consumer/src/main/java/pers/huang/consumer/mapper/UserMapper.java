package pers.huang.consumer.mapper;

import org.apache.ibatis.annotations.Mapper;
import pers.huang.consumer.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Admin
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-01-26 14:14:29
* @Entity pers.huang.consumer.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




