package java.com.Java8.newfeature.Java8.streams;

import java.util.Objects;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    // TODO: Do GroupingBy detailed poc.
    // TODO: Explore Use cases
}



public class GroupByExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("John", "New York"),
            new Person("Jane", "Los Angeles"),
            new Person("George", "New York"),
            new Person("Anna", "San Francisco"),
            new Person("Mike", "Los Angeles")
        );

        Map<String, List<Person>> peopleByCity = people.stream()
            .collect(Collectors.groupingBy(Person::getCity));

        peopleByCity.forEach((city, residents) -> {
            System.out.println("City: " + city);
            residents.forEach(person -> System.out.println(" - " + person));
        });
    }
}

// Output :-
// City: New York
// - Person{name='John', city='New York'}
//- Person{name='George', city='New York'}
// City: Los Angeles
// - Person{name='Jane', city='Los Angeles'}
// - Person{name='Mike', city='Los Angeles'}
// City: San Francisco
// - Person{name='Anna', city='San Francisco'}

public class Person {
    private String name;
    private String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', city='" + city + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }
}



