package uladzislau.epam.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private String name;
    private String skills;
    private String position;

    @JsonProperty("experience")
    private int experience;

    public Employee() {
    }

    public Employee(String name, String skills, String position, int experience) {
        this.name = name;
        this.skills = skills;
        this.position = position;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}