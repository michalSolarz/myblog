package my.blog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import my.blog.auth.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Post {

    @Id
    @SequenceGenerator(name = "post_id_seq", sequenceName = "post_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
    @Column(updatable = false)
    private Long id;
    @Column
    private Date created = new Date();
    @Column
    private Date updated = new Date();
    @Column(length = 300)
    private String title;
    @Column(columnDefinition = "text")
    private String body;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    public Post() {
    }

    @PreUpdate
    public void setLastUpdate() {
        this.updated = new Date();
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {

        return id;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("Post[id=%s, title=%s]", this.id, this.title);
    }
}
