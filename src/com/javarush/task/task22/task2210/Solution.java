package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        getTokens("level22.lesson13.task01", ".");
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer ST = new StringTokenizer(query, delimiter);
        String[] strings = new String[ST.countTokens()];
        for (int a = 0; a < strings.length; a++) {
            strings[a] = ST.nextToken();
        }
        return strings;
    }
}
