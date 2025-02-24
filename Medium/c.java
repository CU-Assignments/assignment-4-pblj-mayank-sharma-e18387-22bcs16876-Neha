import java.util.*;

public class c {
    private static Map<String, List<String>> cardMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Card Collection System!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Card");
            System.out.println("2. Search Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addCard();
                        break;
                    case 2:
                        searchCardsBySymbol();
                        break;
                    case 3:
                        displayAllCards();
                        break;
                    case 4:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter card symbol (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine().trim();

        System.out.print("Enter card name (e.g., Ace, King, 10): ");
        String cardName = scanner.nextLine().trim();

        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(cardName);

        System.out.println("Card added successfully!");
    }

    private static void searchCardsBySymbol() {
        System.out.print("Enter the symbol to search for (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine().trim();

        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards under symbol '" + symbol + "': " + cardMap.get(symbol));
        } else {
            System.out.println("No cards found for the symbol: " + symbol);
        }
    }

    private static void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards in the collection.");
            return;
        }

        System.out.println("\nAll Cards in the Collection:");
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
