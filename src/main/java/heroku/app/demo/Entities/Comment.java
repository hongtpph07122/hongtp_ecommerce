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
    @Column( name = "created_date")
    private Date created_date;
    @Column( name = "parent_id")
    private Long parent_id;

}
