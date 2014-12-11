package jobsite.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity // Будет храниться в базе данных
@Table(name = "account") // Имя таблицы
@NamedQuery(name = Account.FIND_BY_EMAIL, query = "select a from Account a where a.email = :email")
public class Account implements java.io.Serializable {

    public static final String FIND_BY_EMAIL = "Account.findByEmail";

    @Id // Первичный ключ
    @GeneratedValue
    private Long id;

    @Column(unique = true, name = "user_email")
    private String email;

    @JsonIgnore
    private String password;

    private String role = "ROLE_USER";

    protected Account() {

    }

    public Account(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
