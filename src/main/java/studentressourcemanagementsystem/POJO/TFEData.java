package studentressourcemanagementsystem.POJO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.io.Serializable;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TFEData implements Serializable {

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String cfe;
        private String nom_etud;
        private String prenom_etud;
        private String matricule;
        private String nif_ninu_cin;
        private String promotion;
        private String option;
        private String telephonne_etud;
        private String email_etud;
        private String sexe;
        private String intitule_mem;
        private String nom_encadreur;
        private String telephonne_encadreur;
        private String  email_encadreur;
        private String code_projet;









}
