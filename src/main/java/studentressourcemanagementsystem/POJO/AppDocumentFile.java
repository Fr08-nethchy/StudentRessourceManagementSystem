package studentressourcemanagementsystem.POJO;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

public class AppDocumentFile implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private AppDocument appDocument;
    private String imageUrl;
    private String description;


}
