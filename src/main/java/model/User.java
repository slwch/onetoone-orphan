package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @Column(nullable = false, unique=true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique=true)
    private String email;
    @OneToOne(cascade = {CascadeType.MERGE}, orphanRemoval=true)
    @JoinColumn(name = "id_details")
    private UserDetails details;
    
    @Version
    private long version;
    
    User() {}
    
    public User(String username, String password, String email, UserDetails details) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.details = details;
    }
    /*
     * GETTERS & SETTERS
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public UserDetails getDetails() {
        return details;
    }
    public void setDetails(UserDetails details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "User "+version+" " +"[id=" + id + ", username=" + username + ", "
                + "password=" + password + ", email=" + email
                + ", details=" + details + "]";
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}