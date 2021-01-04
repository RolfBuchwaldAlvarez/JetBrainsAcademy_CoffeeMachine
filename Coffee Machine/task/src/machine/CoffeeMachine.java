package machine;

import java.util.*;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static int change = 550;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String action = actionInput(sc);
        System.out.println();

        while (!action.equals("exit")) {
            switch (action) {
                case "buy":
                    buyCoffee(sc);
                    break;
                case "fill":
                    refillCoffeeMachine(sc);
                    break;
                case "take":
                    collectMoney();
                    break;
                case "remaining":
                    printCoffeeMachineState(water, milk, coffeeBeans, cups, change);
                    break;
                default: break;
            }
            action = actionInput(sc);
            System.out.println();
        }
    }

    public static String actionInput(Scanner sc) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return sc.nextLine();
    }

    public static void collectMoney() {
        System.out.println("I gave you $" + change);
        System.out.println();
        change = 0;
    }

    public static void refillCoffeeMachine(Scanner sc) {
        System.out.println("Write how many ml of water do you want to add:");
        int waterRefill = sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milkRefill = sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBeansRefill = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsRefill = sc.nextInt();
        sc.nextLine();
        System.out.println();

        List<Integer> refillList = new ArrayList<>();
        refillList.add(waterRefill);
        refillList.add(milkRefill);
        refillList.add(coffeeBeansRefill);
        refillList.add(cupsRefill);

        water += refillList.get(0);
        milk += refillList.get(1);
        coffeeBeans += refillList.get(2);
        cups += refillList.get(3);
    }

    public static void buyCoffee(Scanner sc) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String selection = sc.nextLine();
        String missingResource = checkIfEnoughResources(selection);

        if (missingResource.equals("none")) {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            switch (selection) {
                case "1": water -= 250;
                    coffeeBeans -= 16;
                    cups -= 1;
                    change += 4;
                    break;
                case "2": water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    cups -= 1;
                    change += 7;
                    break;
                case "3": water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    cups -= 1;
                    change += 6;
                    break;
                case "back": break;
            }
        } else {
            System.out.println("Sorry, not enough " + missingResource + "!");
            System.out.println();
        }
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

    public static String checkIfEnoughResources(String selection) {
        int espressoWater = 250;
        int espressoBeans = 16;
        int latteWater = 350;
        int latteMilk = 75;
        int latteBeans = 20;
        int cappuccinoWater = 200;
        int cappuccinoMilk = 100;
        int cappuccinoBeans = 12;

        int waterResource = 0;
        int milkResource = 0;
        int beanResources = 0;
        int cupResource = 0;

        switch (selection) {
            case "1":
                milkResource = 1;
                if (water / espressoWater >= 1) {
                    waterResource = 1;
                }
                if (coffeeBeans / espressoBeans >= 1) {
                    beanResources = 1;
                }
                if (cups >= 1) {
                    cupResource = 1;
                }
            case "2":
                if (water / latteWater >= 1) {
                    waterResource = 1;
                }
                if (milk / latteMilk >= 1) {
                    milkResource = 1;
                }
                if (coffeeBeans / latteBeans >= 1) {
                    beanResources = 1;
                }
                if (cups >= 1) {
                    cupResource = 1;
                }
            case "3":
                if (water / cappuccinoWater >= 1) {
                    waterResource = 1;
                }
                if (milk / cappuccinoMilk >= 1) {
                    milkResource = 1;
                }
                if (coffeeBeans / cappuccinoBeans >= 1) {
                    beanResources = 1;
                }
                if (cups >= 1) {
                    cupResource = 1;
                }
            default: break;
        }

        Map<String, Integer> list = new HashMap<>();
        list.put("water", waterResource);
        list.put("milk", milkResource);
        list.put("coffee beans", beanResources);
        list.put("cups", cupResource);
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if (Objects.equals(0, entry.getValue())) {
                return entry.getKey();
            }
        }
        return "none";
    }

    /*public static void calculateIngredients(int cupsOfCoffeeNeeded) {
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
    }*/
}