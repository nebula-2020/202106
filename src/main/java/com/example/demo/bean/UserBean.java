package com.example.demo.bean;

import java.io.Serializable;
import java.sql.Timestamp;

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
    private Timestamp createTime;
    @NonNull
    private String password;
    private boolean del;
}
