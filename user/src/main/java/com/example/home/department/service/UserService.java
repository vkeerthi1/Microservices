package com.example.home.department.service;

import com.example.home.department.VO.Department;
import com.example.home.department.VO.FeignClient;
import com.example.home.department.VO.ResponseTemplateVO;
import com.example.home.department.entity.User;
import com.example.home.department.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private FeignClient feignClient;

    public User saveUser(User user) {
        //log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        //log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);


        Department department = feignClient.getUserWithDepartment((long) 2);
        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}