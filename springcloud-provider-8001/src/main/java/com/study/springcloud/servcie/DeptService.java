package com.study.springcloud.servcie;

import com.study.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public boolean delDeptById(Long id);

    public Dept queryById(Long id);
    public List<Dept> queryAll();
}
