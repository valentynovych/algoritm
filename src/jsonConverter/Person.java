package jsonConverter;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String sex;
    private boolean married;
    private List<String> skills;
    private Map<String, String> languagesSkill;
    private Set<String> cars;
    private List<Person> child;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean getMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String, String> getLanguagesSkill() {
        return languagesSkill;
    }

    public void setLanguagesSkill(Map<String, String> languagesSkill) {
        this.languagesSkill = languagesSkill;
    }

    public Set<String> getCars() {
        return cars;
    }

    public void setCars(Set<String> cars) {
        this.cars = cars;
    }

    public void setChild(List<Person> child) {
        this.child = child;
    }

    public boolean isMarried() {
        return married;
    }

    public List<Person> getChild() {
        return child;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", married=" + married +
                ", skills=" + skills +
                ", languagesSkill=" + languagesSkill +
                ", cars=" + cars +
                ", child=" + child +
                '}';
    }
}
