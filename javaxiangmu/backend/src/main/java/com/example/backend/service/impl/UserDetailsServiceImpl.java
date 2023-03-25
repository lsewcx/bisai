package com.example.backend.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;//poji里面的


import com.example.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user=userMapper.selectOne(queryWrapper);
        if(user==null)
        {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new UserDetailsImpl(user);
    }
}
