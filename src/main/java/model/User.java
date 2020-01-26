package model;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ID")
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    //    @ManyToOne
//    @JoinColumn(name = "role_ID", nullable = false)
//    private Role role;

    @Column(name = "date_register")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRegistration;

    @ManyToMany(mappedBy = "follows")
    private Set<User> followers = new HashSet<>(); //śledzony przez

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "follows_followers", joinColumns = {
            @JoinColumn(name = "follows_id")}, inverseJoinColumns = {
            @JoinColumn(name = "followed_id")})
    private Set<User> follows = new HashSet<>(); //obserwujący

    public Long getId() {
        return id;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followed) {
        this.followers = followed;
    }

    public Set<User> getFollows() {
        return follows;
    }

    public void setFollows(Set<User> follows) {
        this.follows = follows;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }
    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
    public User() {
    }
    private User(String login, String name, String lastName, String email, String password) {
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                //", role=" + role +
                ", dateOfRegistration=" + dateOfRegistration +
                ", followed=" + followers +
                ", follows=" + follows +
                '}';
    }
    public static class Builder {
        private String login;
        private String name;
        private String lastName;
        private String email;
        private String password;
        public Builder() {
        }
        public Builder login(String login) {
            this.login = login;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public  Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public User build() {
            return new User(login, name, lastName, email, password);
        }
    }
}