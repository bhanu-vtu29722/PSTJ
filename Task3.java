import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    static boolean isOlderThan(Person p, int limit) {
        return p.age > limit;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            list.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();


        String sortedNames = list.stream()
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .collect(Collectors.joining(" "));

        System.out.println(sortedNames);

        String olderNames = IntStream.range(0, list.size())
                .mapToObj(list::get)
                .filter(p -> Person.isOlderThan(p, ageLimit))
                .map(Person::getName)
                .collect(Collectors.joining(" "));

        System.out.println(olderNames);

   
        String upperNames = list.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));

        System.out.println(upperNames);

        sc.close();
    }
}
