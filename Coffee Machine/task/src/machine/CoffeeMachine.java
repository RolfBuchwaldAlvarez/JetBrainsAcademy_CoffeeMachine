package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int cups = 9;
        int change = 550;

        printCoffeeMachineState(water, milk, coffeeBeans, cups, change);
        System.out.println("Write action (buy, fill, take):");
        String action = sc.nextLine();

        switch (action) {
            case "buy": int selection = buyCoffee(sc);
                        System.out.println();
                        switch (selection) {
                            case 1: water -= 250;
                                    coffeeBeans -= 16;
                                    cups -= 1;
                                    change += 4;
                                    break;
                            case 2: water -= 350;
                                    milk -= 75;
                                    coffeeBeans -= 20;
                                    cups -= 1;
                                    change += 7;
                                    break;
                            case 3: water -= 200;
                                    milk -= 100;
                                    coffeeBeans -= 12;
                                    cups -= 1;
                                    change += 6;
                                    break;
                            default: break;
                        }
                        printCoffeeMachineState(water, milk, coffeeBeans, cups, change);
                        break;
            case "fill": List<Integer> refillList = refillCoffeeMachine(sc);
                         water += refillList.get(0);
                         milk += refillList.get(1);
                         coffeeBeans += refillList.get(2);
                         cups += refillList.get(3);
                         printCoffeeMachineState(water, milk, coffeeBeans, cups, change);
                         break;
            case "take": collectMoney(change);
                         change = 0;
                         printCoffeeMachineState(water, milk, coffeeBeans, cups, change);
                         break;
            default: break;
        }
    }

    public static void collectMoney(int change) {
        System.out.println("I gave you $" + change);
        System.out.println();
    }

    public static List<Integer> refillCoffeeMachine(Scanner sc) {
        System.out.println("Write how many ml of water do you want to add:");
        int waterRefill = sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milkRefill = sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBeansRefill = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsRefill = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        list.add(waterRefill);
        list.add(milkRefill);
        list.add(coffeeBeansRefill);
        list.add(cupsRefill);

        return list;
    }

    public static int buyCoffee(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
        return sc.nextInt();
    }

    public static void printCoffeeMachineState(int water, int milk, int coffeeBeans, int cups, int change) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(change + " of money");
        System.out.println();
    }

    public static void checkIfEnoughResourcesForCoffeeNeeded(int cupsOfCoffeeNeeded, int remainingWater,
                                                             int remainingMilk, int remainingCoffeeBeans) {
        int cupsFromWater = remainingWater / 200;
        int cupsFromMilk = remainingMilk / 50;
        int cupsFromBeans = remainingCoffeeBeans / 15;

        List<Integer> list = new ArrayList<>();
        list.add(cupsFromWater);
        list.add(cupsFromMilk);
        list.add(cupsFromBeans);

        int min = Collections.min(list);

        if (min == cupsOfCoffeeNeeded) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (min > cupsOfCoffeeNeeded){
            int excessCups = min - cupsOfCoffeeNeeded;
            System.out.println("Yes, I can make that amount of coffee (and even " + excessCups +
                " more than that");
        } else {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        }
    }

    public static void calculateIngredients(int cupsOfCoffeeNeeded) {
        System.out.println(waterNeeded(cupsOfCoffeeNeeded) + " ml of water");
        System.out.println(milkNeeded(cupsOfCoffeeNeeded) + " ml of milk");
        System.out.println(beansNeeded(cupsOfCoffeeNeeded) + " g of coffee beans");
    }

    public static int waterNeeded(int cupsOfCoffeeNeeded) {
        return cupsOfCoffeeNeeded * 200;
    }

    public static int milkNeeded(int cupsOfCoffeeNeeded) {
        return cupsOfCoffeeNeeded * 50;
    }

    public static int beansNeeded(int cupsOfCoffeeNeeded) {
        return cupsOfCoffeeNeeded * 15;
    }

    public static void printCoffeeMachineMainFunctions() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}