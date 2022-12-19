package edu.wfit.hotelmanage.util;

import org.junit.jupiter.api.Test;

class PasswordUtilTest {


    @Test
    void getPasswordBySha256() {
        String passwordBySha256 = PasswordUtil.getPasswordByMD5("123456");
        String passwordBySha2561 = PasswordUtil.getPasswordByMD5("123456");
        System.out.println(passwordBySha256);
        System.out.println(passwordBySha2561);
    }
}