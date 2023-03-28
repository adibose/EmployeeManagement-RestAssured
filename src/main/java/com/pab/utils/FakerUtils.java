package com.pab.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    private FakerUtils(){}

    private static final Faker faker = new Faker();

    static int getNumber(int min, int max){
        return faker.number().numberBetween(min, max);
    }

    static String getfirstName(){
        return faker.name().firstName();
    }

    static String getlastName(){
        return faker.name().lastName();
    }

    static String getEmailAddress(){
        return faker.internet().emailAddress();
    }


}
