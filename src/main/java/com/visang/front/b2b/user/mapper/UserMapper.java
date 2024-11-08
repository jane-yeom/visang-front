package com.visang.front.b2b.user.mapper;

import com.visang.front.b2b.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
}