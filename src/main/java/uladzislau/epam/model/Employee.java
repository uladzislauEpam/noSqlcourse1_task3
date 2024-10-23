package uladzislau.epam.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private String name;
    private String skills;
    private String verified;

    @JsonProperty("experience")
    private int experience;

    public Employee() {
    }

    public Employee(String name, String skills, String verified, int experience) {
        this.name = name;
        this.skills = skills;
        this.verified = verified;
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

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}