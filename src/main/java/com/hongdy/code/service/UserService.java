package com.hongdy.code.service;

import com.hongdy.code.dto.User;
import com.hongdy.code.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insert(User user) throws Exception {
        userMapper.insert(user);
        if (user.getId().equals("2")) {
            throw new Exception("aaa");
        }

    }

    @Transactional(readOnly = true)
    public User select(String id) {
        return userMapper.select(id);
    }
}
