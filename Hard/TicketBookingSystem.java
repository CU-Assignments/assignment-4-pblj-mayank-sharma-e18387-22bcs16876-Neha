import java.util.*;

class TicketBookingSystem {
    private static int availableSeats = 10;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Ticket Booking System!");
        System.out.print("Enter the number of VIP bookings: ");
        int vipCount = scanner.nextInt();
        System.out.print("Enter the number of regular bookings: ");
        int regularCount = scanner.nextInt();

        List<Thread> threads = new ArrayList<>();

        // Create VIP booking threads (higher priority)
        for (int i = 1; i <= vipCount; i++) {
            Thread vipThread = new Thread(new BookingTask("VIP-User" + i));
            vipThread.setPriority(Thread.MAX_PRIORITY);
            threads.add(vipThread);
        }

        // Create Regular booking threads (lower priority)
        for (int i = 1; i <= regularCount; i++) {
            Thread regularThread = new Thread(new BookingTask("Regular-User" + i));
            regularThread.setPriority(Thread.NORM_PRIORITY);
            threads.add(regularThread);
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Booking process completed. Remaining seats: " + availableSeats);
        scanner.close();
    }

    static class BookingTask implements Runnable {
        private final String userName;

        public BookingTask(String userName) {
            this.userName = userName;
        }

        @Override
        public void run() {
            synchronized (lock) {
                if (availableSeats > 0) {
                    System.out.println(userName + " booked a seat.");
                    availableSeats--;
                } else {
                    System.out.println(userName + " failed to book. No seats available.");
                }
            }
        }
    }
}
