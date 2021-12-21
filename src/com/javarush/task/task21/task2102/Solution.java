package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isModifierSet(Solution.class.getModifiers(), Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(Solution.class.getModifiers(), Modifier.STATIC));   //false
        System.out.println(isModifierSet(getMainMethod().getModifiers(), Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        return (allModifiers & specificModifier) > 0;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("main")) {
                return method;
            }
        }

        return null;
    }
}
