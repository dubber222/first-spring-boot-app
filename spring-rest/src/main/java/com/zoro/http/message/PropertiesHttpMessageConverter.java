package com.zoro.http.message;

import com.zoro.domain.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/8/5
 */
public class PropertiesHttpMessageConverter extends AbstractHttpMessageConverter<Person> {

    public PropertiesHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
}

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    protected Person readInternal(Class<? extends Person> clazz,
                                  HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        /**
         *
         */
        InputStream inputStream = inputMessage.getBody();
        Properties pp = new Properties();
        pp.load(new InputStreamReader(inputStream, getDefaultCharset()));

        //将文本内容变成 pojo
        Person person = new Person();
        person.setId(Integer.valueOf(pp.getProperty("person.id")));
        person.setName(pp.getProperty("person.name"));
        return person;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        OutputStream os = outputMessage.getBody();
        Properties pp = new Properties();
        pp.setProperty("person.id", String.valueOf(person.getId()));
        pp.setProperty("person.id", person.getName());
        pp.store(new OutputStreamWriter(os, getDefaultCharset()), "application/properties+person");

    }
}
