package com.hongdy.code.mapper;

import com.hongdy.code.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    User select(String id);

    void insert(User user);
}
