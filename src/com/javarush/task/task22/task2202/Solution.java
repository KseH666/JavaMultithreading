package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("null"));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        } else {
            String[] list = string.split(" ");
            StringBuilder con = new StringBuilder();
            try {
                for (int i = 1; i <= 4; i++) {
                    con.append(" ").append(list[i]);
                }
                return con.substring(1);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new TooShortStringException();
            }
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
