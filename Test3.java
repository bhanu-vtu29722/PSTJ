import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test3{

    // Helper class to store event details
    static class Event {
        String name;
        LocalDate date;

        Event(String name, LocalDate date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Event> events;
        int targetMonth;
        // Read input
        try (Scanner scanner = new Scanner(System.in)) {
            // Read input
            if (!scanner.hasNextInt()) {
                scanner.close();
                return;
            }   int numEvents = scanner.nextInt();
            events = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            for (int i = 0; i < numEvents; i++) {
                String name = scanner.next();
                String dateStr = scanner.next();
                // Parse date string to LocalDate using the formatter
                LocalDate date = LocalDate.parse(dateStr, formatter);
                events.add(new Event(name, date));
            }   // Read the target month number
            targetMonth = scanner.nextInt();
        }

        // 1. Sort events chronologically
        // Use Comparator.comparing(Event::date) to sort by the date field
        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(event -> event.date))
                .collect(Collectors.toList());

        // 2. Determine earliest and latest events
        // The first and last elements of the sorted list are the min and max
        if (!sortedEvents.isEmpty()) {
            Event earliestEvent = sortedEvents.get(0);
            Event latestEvent = sortedEvents.get(sortedEvents.size() - 1);

            // 3. Identify all events that occur in the specific month
            // Use stream filter with LocalDate.getMonthValue()
            List<Event> eventsInMonth = events.stream()
                    .filter(event -> event.date.getMonthValue() == targetMonth)
                    .collect(Collectors.toList());

            // Print the output as specified in the problem
            for (Event event : sortedEvents) {
                System.out.println(event.name);
            }
            System.out.println(earliestEvent.name);
            System.out.println(latestEvent.name);
            for (Event event : eventsInMonth) {
                System.out.println(event.name);
            }
        }
    }
}
