package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table ( name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    private Long id;
    @Column( name = "content")
    private String content;
    @Column( name = "createdDate")
    private Date createdDate;
    @Column( name = "parentId")
    private Long parentId;

}
