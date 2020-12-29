package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffeeNeeded = sc.nextInt();
        System.out.println("For " + cupsOfCoffeeNeeded + " cups of coffee you will need:");
        calculateIngredients(cupsOfCoffeeNeeded);
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
