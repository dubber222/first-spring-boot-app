package com.zoro.springboothello;

import com.zoro.springboothello.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2018/8/17.
 *
 * @author dubber
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiestParamTest {

    @Autowired
    Book book;

    @Test
    public void validateParam() {
        System.out.println(book);
    }
}
