package Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}

public class eventSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate date = LocalDate.parse(dateStr, formatter);
            events.add(new Event(name, date));
        }

        int month = sc.nextInt();

        events.sort(Comparator.comparing(e -> e.date));
        events.forEach(e -> System.out.print(e.name + " "));
        System.out.println();

        Event earliest = Collections.min(events, Comparator.comparing(e -> e.date));
        System.out.println(earliest.name);

        Event latest = Collections.max(events, Comparator.comparing(e -> e.date));
        System.out.println(latest.name);

        List<String> monthEvents = events.stream()
                .filter(e -> e.date.getMonthValue() == month)
                .map(e -> e.name)
                .collect(Collectors.toList());

        monthEvents.forEach(e -> System.out.print(e + " "));
    }
}
