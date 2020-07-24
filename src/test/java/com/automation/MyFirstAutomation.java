package com.automation;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MyFirstAutomation {
    @Test
    void myFirstTest() {

        int result = sum(2,9);

        Assertions.assertEquals(11,result);

    }
    public static int sum(int a, int b){
        return a+b;


    }
}
