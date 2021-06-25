package com.study.springcloud.controller;

import com.study.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者不需要由service层
 */
@RestController
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    private static final String REST_URL_PRIFIX = "http://localhost:8001";
    //restTemplate 一般需要（url，实体，Class<T> responseType）
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        //"/dept/get/" 由服务提供者提供
        return restTemplate.getForObject(REST_URL_PRIFIX+"/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> deptList(){
        //"/dept/get/" 由服务提供者提供
        return restTemplate.getForObject(REST_URL_PRIFIX+"/dept/list", List.class);
    }

    @RequestMapping("/consumer/dept/add")
    public Boolean addDept(Dept dept){
        //"/dept/get/" 由服务提供者提供
        return restTemplate.postForObject(REST_URL_PRIFIX+"/dept/add" , dept,Boolean.class);
    }
}
