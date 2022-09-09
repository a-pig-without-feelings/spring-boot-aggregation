package com.roadhog.controller;

import com.roadhog.domin.UserPo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
@Api(tags = "swagger-测试")
public class SwaggerController {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public UserPo hello() {
        UserPo userPo = new UserPo();
        userPo.setUserName("roadhog");
        userPo.setPassWord("123456");
        return userPo;
    }

}
