package com.javarush.task.task21.task2113;



import java.util.ArrayList;

import java.util.List;

public class Hippodrome {
    public static Hippodrome game;

    private static List<Horse> horses;


    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }

    public void run () {
        int count = 0;
        while (count < 100) {
            count++;
            move();
            print();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move () {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }
    public void print () {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int y = 0; y < 10; y++) {
            System.out.println();
        }

    }

    public Horse getWinner(){
        int max = 0;
        int right = 0;
        for(int a = 0; a < horses.size(); a++){
            if(horses.get(a).getDistance()>max){
                max = (int) horses.get(a).getDistance();
                right = a;
            }
        }
        return horses.get(right);
    }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }





    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("\uD83D\uDC0E №1", 3, 0);
        Horse horse2 = new Horse("\uD83D\uDC0E №2", 3, 0);
        Horse horse3 = new Horse("\uD83D\uDC0E №3", 3, 0);
        horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();


    }
}
