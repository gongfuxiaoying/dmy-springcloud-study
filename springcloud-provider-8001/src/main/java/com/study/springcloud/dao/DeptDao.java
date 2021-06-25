package com.study.springcloud.dao;

import com.study.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);
    public boolean delDeptById(Long deptno);

    public Dept queryById(Long deptno);
    public List<Dept> queryAll();
}
