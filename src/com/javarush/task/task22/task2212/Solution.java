package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        return (telNumber.matches("^\\+(\\d[\\-()]?){11}\\d$") || telNumber.matches("^[(\\d]-?(\\d[\\-)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");
    }


    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));//true
        System.out.println(checkTelNumber("+380501234567"));//true
        System.out.println(checkTelNumber("+38(050)1234567"));//true
        System.out.println(checkTelNumber("+38050123-45-67"));//true
        System.out.println(checkTelNumber("050123-4567"));//true
        System.out.println(checkTelNumber("+38)050(1234567"));//false
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));// false
        System.out.println(checkTelNumber("050ххх4567"));//false
        System.out.println(checkTelNumber("050123456"));//false
        System.out.println(checkTelNumber("(0)501234567"));//false
    }
}
