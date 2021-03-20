package mapping;

import java.util.Objects;

public class PersonRequestModel {
    private String name;
    private String job;
    private int id;
    private String createdAt;

    public PersonRequestModel(String name, String job) {
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
    public String toString() {
        return " Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id=" + id +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
