package jsonConverter;

import java.util.*;

public class ConverterDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("William");
        person.setLastName("Ronger");
        person.setAge(32);
        person.setSex("male");
        person.setMarried(true);

        List<String> skills = new ArrayList<>();
        skills.add("Spring Boot");
        skills.add("Spring MVC");
        skills.add("Extremal programming");
        person.setSkills(skills);

        Set<String> cars = new HashSet<>();
        cars.add("Volvo FX90");
        cars.add("Maserati Levante");
        person.setCars(cars);

        Map<String, String> languages = new HashMap<>();
        languages.put("English", "Advanced");
        languages.put("French", "B1");
        languages.put("Deutch", "A2");
        person.setLanguagesSkill(languages);

        Person children = new Person();
        children.setFirstName("Mike");
        children.setLastName("Ronef");
        children.setAge(1);
        children.setSex("male");

        Person children1 = new Person();
        children1.setFirstName("John");
        children1.setLastName("Wick");
        children1.setAge(10);
        children1.setSex("male");
        skills.clear();
        skills.add("Play games");
        skills.add("Eating");

        children1.setSkills(skills);
        Map<String, String> languagesChild = new HashMap<>();
        languagesChild.put("English", "Elementary");
        children1.setLanguagesSkill(languagesChild);

        List<Person> child = new LinkedList<>();
        child.add(children);
        child.add(children1);
        person.setChild(child);

        Convert jsonConverter = new Convert();
        String json = jsonConverter.convertToJson(person);
        System.out.println(json);
    }
}
