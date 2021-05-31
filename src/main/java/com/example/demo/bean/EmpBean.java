package com.example.demo.bean;

import java.io.Serializable;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class EmpBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int empno;
    @NonNull
    private String ename;
    @NonNull
    private String job;
    private int mgr;
    private int hiredate;
    private float sal;
    private float comm;
    private int deptno;
}
