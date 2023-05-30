package ra.ra.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 2, max = 800)
    @Pattern(regexp = "^[a-zA-Z]*$",message = "không đúng định dạng")
    private String name;
    @NotBlank
    @Length(min = 2, max = 300)
    @Pattern(regexp = "^[a-zA-Z]*",message = "không đúng định dạng")
    private String singer;
    @NotBlank
    @Length(min = 2 ,max = 1000)
    @Pattern(regexp = "^[a-zA-Z,]*$",message = "không đúng định dạng")
    private String category;

    public Song() {
    }

    public Song(Long id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
