package com.study.springcloud.servcie;

import com.study.springcloud.dao.DeptDao;
import com.study.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public boolean delDeptById(Long id) {
        deptDao.delDeptById(id);
        return false;
    }

    @Override
    public Dept queryById(Long id) {
        Dept dept = deptDao.queryById(id);
        return dept;
    }

    @Override
    public List<Dept> queryAll() {
        List<Dept> depts = deptDao.queryAll();
        return depts;
    }
}
