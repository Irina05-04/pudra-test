package by.bsu.fsc.Derecha.domain;

import by.bsu.fsc.Derecha.util.Util;
import com.github.javafaker.Faker;

public class User {

    public static final String CORRECT_LOGIN = "irisha.dieriecha@mail.ru";
    public static final String CORRECT_PSW = "1z2x3c4v5b6n";
    public static final String CORRECT_RESULTS = "Ирина Дереча";

    public static String generateEncorrectLogin(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    public static String generateEncorrectPsw(){

        return Util.generateRandomString(10);
    }
}
