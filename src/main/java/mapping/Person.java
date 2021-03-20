package mapping;

import java.util.Objects;

public class Person {
    private String name;
    private String job;
    private int id;
    private String createdAt;

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(job, person.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job);
    }

    @Override
    public String toString() {
        return " Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id=" + id +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
