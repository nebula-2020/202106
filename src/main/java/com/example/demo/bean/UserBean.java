package com.example.demo.bean;

import java.sql.Timestamp;
import lombok.*;

@AllArgsConstructor

@Setter

@Getter
public class UserBean
{
    @NonNull
    private long id;
    @NonNull
    private String name;
    @NonNull
    private Timestamp createTime;
    @NonNull
    private String password;
    @NonNull
    private boolean del;
}
