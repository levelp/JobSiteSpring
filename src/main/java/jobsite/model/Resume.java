
package jobsite.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "resume")
public class Resume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String infAboutUser;
    private int salary;
    private String phone;
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Account user;

    @ElementCollection
    private List<String> citizenship;

    @ElementCollection
    private List<String> countOfLanguage;

    @ElementCollection
    private List<String> education;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<String> employment;

    public Resume() {
    }

    public Resume(Account user, String phone) {
        this.user = user;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfAboutUser() {
        return infAboutUser;
    }

    public void setInfAboutUser(String infAboutUser) {
        this.infAboutUser = infAboutUser;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(List<String> citizenship) {
        this.citizenship = citizenship;
    }

    public List<String> getCountOfLanguage() {
        return countOfLanguage;
    }

    public void setCountOfLanguage(List<String> countOfLanguage) {
        this.countOfLanguage = countOfLanguage;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getEmployment() {
        return employment;
    }

    public void setEmployment(List<String> employment) {
        this.employment = employment;
    }
}
