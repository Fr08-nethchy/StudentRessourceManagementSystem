package studentressourcemanagementsystem.service;

import org.springframework.http.ResponseEntity;
import studentressourcemanagementsystem.POJO.Paiement;
import studentressourcemanagementsystem.POJO.TFEData;

import java.util.List;
import java.util.Map;

public interface PaiementService {

    ResponseEntity<?> savePaiement(Map<String,String> request);
    ResponseEntity<?> updatePaiement( Map<String,String> request);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<List<Paiement>> getAll();
    ResponseEntity<Paiement> getOne(Long id);
}
