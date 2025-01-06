package com.nhnacademy;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.lang3.StringUtils;
public class Main {
    public static void main(String[] args) {

        // 1번 : 1 부터 100까지 난수 생성하기
        RandomDataGenerator rdg = new RandomDataGenerator();

        int randomInt = rdg.nextInt(1, 100);
        System.out.println(randomInt);

        // 2번 : (문자열의 Null 또는 빈 문자열 체크)
        String testWord = "Test";
        String testWord2 = "";

        if(StringUtils.isEmpty(testWord)) {
            System.out.println("testWord is empty\n");
        }else {
            System.out.println(testWord);
        }

        if(StringUtils.isEmpty(testWord2)) {
            System.out.println("testWord2 is empty");
        }

        // 3번
    }
}
