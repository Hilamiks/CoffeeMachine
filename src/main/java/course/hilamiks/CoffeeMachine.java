package course.hilamiks;

import java.util.Scanner;

public class CoffeeMachine {
    static int reqMilk;
    static int startMilk = 540;
    static int reqWater ;
    static int startWater = 400;
    static int reqBeans;
    static int startBeans = 120;
    static int startCups = 9;
    static int reqCups;
    static int reqMoney;
    static int startMoney = 550;
    static boolean running = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(running){
            performFunctions();
        }
    }
    public static void machineStatus(){
        System.out.println("The coffee machine has:");
        System.out.println(startWater+" ml of water");
        System.out.println(startMilk+" ml of milk");
        System.out.println(startBeans+" g of coffee beans");
        System.out.println(startCups+" disposable cups");
        System.out.println("$"+startMoney+" of money");
    }
    public static void buy(){
        System.out.println("What do you want to buy? 1-espresso, 2 - latte, 3 - cappuccino, back - to main menu");
        String coffeType = scanner.nextLine();
        switch (coffeType){
            case "1":
                reqWater = 250;
                reqMilk = 0;
                reqBeans = 16;
                reqCups = 1;
                reqMoney = -4;
                checkResources();
                adjust();
                break;
            case "2":
                reqWater = 350;
                reqMilk = 75;
                reqBeans = 20;
                reqCups = 1;
                reqMoney = -7;
                checkResources();
                adjust();
                break;
            case "3":
                reqWater = 200;
                reqMilk = 100;
                reqBeans = 12;
                reqCups = 1;
                reqMoney = -6;
                checkResources();
                adjust();
                break;
            default:
                reqWater = 0;
                reqMilk = 0;
                reqBeans = 0;
                reqCups = 0;
                reqMoney = 0;
                break;
        }
    }
    public static void fill(){
        System.out.println("Write how many ml of water you want to add:");
        reqWater = scanner.nextInt()*-1;
        System.out.println("Write how many ml of milk you want to add:");
        reqMilk = scanner.nextInt()*-1;
        System.out.println("Write how grams of coffee you want to add:");
        reqBeans = scanner.nextInt()*-1;
        System.out.println("Write how many disposable cups you want to add:");
        reqCups = scanner.nextInt()*-1;
        scanner.nextLine();
        adjust();
    }
    public static void take(){
        System.out.println("I gave you $"+startMoney);
        reqMoney=startMoney;
        adjust();
    }
    public static void restart(){
        reqMoney = 0;
        reqBeans = 0;
        reqCups = 0;
        reqMilk = 0;
        reqWater = 0;
    }
    public static void adjust(){
        startWater -= reqWater;
        startMilk -= reqMilk;
        startBeans -= reqBeans;
        startCups -= reqCups;
        startMoney -= reqMoney;
    }
    public static void checkResources(){
        if ((startWater-reqWater) < 0) {
            System.out.println("Sorry, not enough water!");
            restart();
        } else if ((startMilk-reqMilk) < 0) {
            System.out.println("Sorry, not enough milk!");
            restart();
        } else if ((startBeans-reqBeans) < 0) {
            System.out.println("Sorry, not enough coffee beans");
            restart();
        } else if ((startCups-reqCups) < 0) {
            System.out.println("Sorry, not enough disposable cups");
            restart();
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }
    }
    public static void performFunctions(){
        restart();
        System.out.println("Write action (buy, fill, take, remaining, exit)");
        String menu = scanner.nextLine();
        switch (menu) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                machineStatus();
                break;
            case "exit":
                running = false;
                scanner.close();
                break;
        }
    }
}

