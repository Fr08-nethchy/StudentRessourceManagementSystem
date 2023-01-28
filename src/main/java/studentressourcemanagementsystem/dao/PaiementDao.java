package studentressourcemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentressourcemanagementsystem.POJO.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
    Paiement findPaiementById(Long id);
}
