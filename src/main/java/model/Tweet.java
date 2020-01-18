package model;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "tweet")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_author")
    private User author;

    @Column(name = "published_at")
    @CreationTimestamp
    private Date publishedAt;

    @Column(name = "message")
    private String message;
    public Tweet() {
    }
    public Tweet(User author, String message) {
        this.author = author;
        this.message = message;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Long getId() {
        return id;
    }
    public User getAuthor() {
        return author;
    }
    public Date getPublishedAt() {
        return publishedAt;
    }
    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", author=" + author +
                ", publishedAt=" + publishedAt +
                ", message='" + message + '\'' +
                '}';
    }
}