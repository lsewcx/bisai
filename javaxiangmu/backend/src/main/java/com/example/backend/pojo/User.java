package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;//pom里面下的依赖通过maven包
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
}
