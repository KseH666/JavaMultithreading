package com.javarush.task.task21.task2101;

import java.util.Arrays;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        int[] ipBytes = new int[4];
        int[] maskBytes = new int[4];
        for (int a = 0; a < ip.length; a++) {
            int r = ip[a];
            if (r < 0) {
                r = r + 256;
            }
            ipBytes[a] = r;
        }
        for (int a = 0; a < mask.length; a++) {
            int r = mask[a];
            if (r < 0) {
                r = r + 256;
            }
            maskBytes[a] = r;
        }
        byte[] New = new byte[4];
        for (int a = 0; a < New.length; a++) {
            int z = (byte) ipBytes[a] & (byte) maskBytes[a];
            if (z < 0) {
                z = z + 256;
            }
            New[a] = (byte) z;
        }
        return New;
    }

    public static void print(byte[] bytes) {
        for (int a = 0; a < bytes.length; a++) {
            int b = 0;
            if (bytes[a] < 0) {
                b = bytes[a] + 256;
            } else {
                b = bytes[a];
            }
            String ab = binar(b);
            StringBuilder sb = new StringBuilder(ab);
            while (sb.length() < 8) {
                sb.insert(0, "0");
            }
            if (a != bytes.length - 1) {
                System.out.print(sb + " ");
            } else{
                System.out.println(sb);
            }
        }
    }

    public static String binar(int n) {
        int i = bitsInNumber(n);
        int bit;
        StringBuilder a = new StringBuilder();
        while (--i >= 0) {
            bit = (n & (1 << i)) == 0 ? 0 : 1;
            a.append(bit);
        }
        return a.toString();
    }

    public static int bitsInNumber(int n) {
        int res = 0;
        while (n > 0) {
            n >>= 1;
            res++;
        }
        return res;
    }
}
