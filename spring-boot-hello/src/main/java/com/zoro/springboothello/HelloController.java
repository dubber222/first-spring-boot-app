package com.zoro.springboothello;

import com.zoro.springboothello.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/8/17.
 *
 * @author dubber
 */
@RestController
public class HelloController {

    @Autowired
    Book book;

    @PostMapping(value = "/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping(value = "/book")
    public Book book() {
        System.out.println(book);
        book.setAuthor("zoro");
        return book;
    }

}
