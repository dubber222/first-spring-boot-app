package com.zoro.controller;

import com.zoro.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * {@link} {@link RestController}
 *
 * @author dubber
 * @date 2018/8/4
 */
@RestController
public class PersonRestController {
    @GetMapping("person/{id}")
    public Person person(@PathVariable int id, @RequestParam(required = false) String name) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

    /**
     * 测试 扩展的的自描述信息
     * RequestBody 内容是json
     * 响应内容是properties
     *
     * @param person
     * @return
     */
    @PostMapping(value = "person/json2properties",
            consumes = "application/properties+person",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Person json2properties(@RequestBody Person person) {
        return person;
    }

    /**
     * 测试 扩展的的自描述信息
     * RequestBody 内容是properties
     * 响应内容是 json
     *
     * @param person
     * @return
     */
    @PostMapping(value = "person/properties2json",
            consumes = "application/properties+person", // 指定处理请求的提交内容类型（Content-Type）
            produces = "application/json;charset=UTF-8" // 指定返回的内容类型
    )
    public Person properties2json(@RequestBody Person person) {
        return person;
    }

}
