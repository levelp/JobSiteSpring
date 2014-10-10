package jobsite.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Резюме
 */
@SuppressWarnings("serial")
//@Entity
//@Table(name = "resume")
public class Resume {
    @Id
    @GeneratedValue
    private Long id;

    private List<String> citizenship, countOfLanguage, education, skills, employment;

    private String infAboutUser;
    private int salary;
    private String phone;
    private Account user;
    /**
     * Место (город) подачи резюме
     */
    private String location;

    public Resume(Account user, String phone) {
        this.phone = phone;
        this.user = user;
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
}
