package com.zoro.springbootvalidate.domian;

import com.zoro.springbootvalidate.validation.constraints.ValidCardNumber;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created on 2018/8/16.
 *
 * @author dubber
 */
public class User {
    @Max(value = 3)
    private Long id;
    @NotNull
    private String name;

    @ValidCardNumber
    private String cardNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
