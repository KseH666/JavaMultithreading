package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())))) {

            ArrayList<String> list = new ArrayList<>();
            while (reader.ready()) {
                String[] arr = reader.readLine().split(" ");
                list.addAll(Arrays.asList(arr));
            }
            for (int i = 0; i < list.size(); ) {
                String s1 = list.get(i);
                list.remove(i);
                for (int j = 0; j < list.size(); j++) {
                    StringBuilder str = new StringBuilder(list.get(j)).reverse();
                    if (s1.equals(str.toString())) {
                        Pair p = new Pair(s1, list.get(j));
                        result.add(p);
                        list.remove(j);
                        break;
                    }
                }
            }
        }
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        Pair() {
        }

        Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
