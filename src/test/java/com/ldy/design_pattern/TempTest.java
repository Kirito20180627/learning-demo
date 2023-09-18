package com.ldy.design_pattern;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class TempTest {

    @Test
    public void test1() {
        String s = "hshaksdhqqkqwkasfa123shgjqijasjkdhajkcsnidh";
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                stack.addFirst(i);
            } else if (chars[i] == 's') {
                if (!stack.isEmpty()) {
                    Integer aIndex = stack.removeFirst();
                    String substring = s.substring(aIndex + 1, i);
                    if (!substring.isEmpty()) {
                        result.add(substring);
                    }
                }
            }
        }
        System.out.println(result);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 3; i++) {
            int anInt = Integer.parseInt("pants");
            System.out.println(anInt);
            System.out.println("round : " + i);
        }
        System.out.println("test finish");
    }
    @Test
    public void test3() {
        for (int i = 0; i < 3; i++) {
            try {
                int anInt = Integer.parseInt("pants");
                System.out.println(anInt);
            } catch (Exception e) {
                System.out.println("false input");
            }
            System.out.println("round : " + i);
        }
        System.out.println("test finish");
    }
}
