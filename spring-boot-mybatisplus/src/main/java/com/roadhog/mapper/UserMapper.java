package com.roadhog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadhog.domin.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
