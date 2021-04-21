package com.example.demo.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

// import com.example.demo.annotation.Table;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
// @Table(name = "user")
public class UserBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String phone;
    @NonNull
    private LocalDateTime createTime;
    @NonNull
    private String password;
    private boolean del;
}
