import java.util.*;

public class ProbabilityExperiment {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Probability Experiment ===");
            System.out.println("1. Simulate Coin Tosses");
            System.out.println("2. Roll a Dice");
            System.out.println("3. Draw Cards");
            System.out.println("4. Probability of Compound Events");
            System.out.println("5. Exit");
            System.out.print("Choose a task: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    simulateCoinTosses();
                    break;
                case 2:
                    rollDie();
                    break;
                case 3:
                    drawCards();
                    break;
                case 4:
                    compoundEvents();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }

    public static void simulateCoinTosses() {
        int heads = 0;
        int tails = 0;

        for (int i = 0; i < 100; i++) {
            int toss = random.nextInt(2);

            if (toss == 0) {
                heads++;
            } else {
                tails++;
            }
        }

        System.out.println("\n--- Coin Toss Results ---");
        System.out.println("Heads: " + heads);
        System.out.println("Tails: " + tails);

        printBar("Heads", heads);
        printBar("Tails", tails);
    }

    public static void rollDie() {
        int[] frequency = new int[6];

        for (int i = 0; i < 60; i++) {
            int roll = random.nextInt(6) + 1;
            frequency[roll - 1]++;
        }

        System.out.println("\n--- Dice Roll Results ---");

        for (int i = 0; i < frequency.length; i++) {
            System.out.println((i + 1) + ": " + frequency[i]);
            printBar("Side " + (i + 1), frequency[i]);
        }
    }

    public static void drawCards() {
        ArrayList<String> deck = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            deck.add("Red");
            deck.add("Black");
        }

        Collections.shuffle(deck);

        int red = 0;
        int black = 0;

        for (int i = 0; i < 20; i++) {
            String card = deck.get(i);

            if (card.equals("Red")) {
                red++;
            } else {
                black++;
            }
        }

        System.out.println("\n--- Card Drawing Results ---");
        System.out.println("Red cards: " + red);
        System.out.println("Black cards: " + black);

        printBar("Red", red);
        printBar("Black", black);
    }

    public static void compoundEvents() {
        int bothHeads = 0;
        int atLeastOneHead = 0;
        int neitherHeads = 0;

        for (int i = 0; i < 50; i++) {
            boolean coin1Heads = random.nextBoolean();
            boolean coin2Heads = random.nextBoolean();

            if (coin1Heads && coin2Heads) {
                bothHeads++;
            }

            if (coin1Heads || coin2Heads) {
                atLeastOneHead++;
            } else {
                neitherHeads++;
            }
        }

        System.out.println("\n--- Compound Events Results ---");
        System.out.println("Both heads: " + bothHeads);
        System.out.println("At least one head: " + atLeastOneHead);
        System.out.println("No heads: " + neitherHeads);

        printBar("Both Heads", bothHeads);
        printBar("At Least One Head", atLeastOneHead);
        printBar("No Heads", neitherHeads);
    }

    public static void printBar(String label, int count) {
        System.out.print(label + " | ");

        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }

        System.out.println(" (" + count + ")");
    }
}