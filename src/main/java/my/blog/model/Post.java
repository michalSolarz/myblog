package my.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @SequenceGenerator(name = "post_id_seq", sequenceName = "post_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
    @Column(updatable = false)
    private Long id;
    @Column(length = 300)
    private String title;
    @Column(columnDefinition = "text")
    private String body;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Long getId() {

        return id;
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

    @Override
    public String toString() {
        return String.format("Post[id=%s, title=%s]", this.id, this.title);
    }
}
