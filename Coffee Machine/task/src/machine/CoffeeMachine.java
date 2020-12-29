package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int remainingWater = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int remainingMilk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int remainingCoffeeBeans = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffeeNeeded = sc.nextInt();
        System.out.println("For " + cupsOfCoffeeNeeded + " cups of coffee you will need:");
        checkIfEnoughResourcesForCoffeeNeeded(cupsOfCoffeeNeeded, remainingWater, remainingMilk, remainingCoffeeBeans);
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