package studentressourcemanagementsystem.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
@Entity
@Data

@Builder
@AllArgsConstructor @NoArgsConstructor
public class Paiement implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
     private double montant;
     private String NoVersement;
     private String receptionniste;
     private String description;
     @Transient
     @JsonIgnore
     private Long idTFE;
     @ManyToOne
     private TFEData tfeData ;

     
}
