package studentressourcemanagementsystem.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class AppDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String intitule_mem;
    private String option;
    private String promotion;
    private String dateUpload;
    @OneToMany
    private List<AppDocumentFile> appDocumentFileList;




}
