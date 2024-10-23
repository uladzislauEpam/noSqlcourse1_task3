package uladzislau.epam.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("name")
    private String name;

    @JsonProperty("skills")
    private String skills;

    @JsonProperty("verified")
    private boolean verified;

    @JsonProperty("experience")
    private int experience;

    public Employee() {
    }

    public Employee(String name, String skills, boolean verified, int experience) {
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

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}