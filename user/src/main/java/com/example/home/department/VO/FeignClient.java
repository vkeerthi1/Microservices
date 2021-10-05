package com.example.home.department.VO;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@org.springframework.cloud.openfeign.FeignClient(value="department-service",url="http://localhost:9091/departments/")
public interface FeignClient {

    @GetMapping
    String clientresponse();

    @GetMapping("/{id}")
    Department getUserWithDepartment(@PathVariable("id") Long id);


}
