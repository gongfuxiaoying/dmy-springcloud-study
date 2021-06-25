package com.study.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 实体类
 */
@Data
@NoArgsConstructor //无参构造器
@Accessors(chain = true) //链式写法 dept.setDeptno(11).setDeptname("开发部");
public class Dept implements Serializable {
    private Long deptno;
    private String deptname;
    /**
     * 当前数据存在于哪一个数据库
     * 微服务是一个服务对应一个数据库,同一个信息可能存在于不同的数据库
     */
    private String dbSource;

    public Dept(String dname) {
        this.deptname = dname;
    }
}
