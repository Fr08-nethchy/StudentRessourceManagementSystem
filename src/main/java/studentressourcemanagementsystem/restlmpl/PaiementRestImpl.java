package studentressourcemanagementsystem.restlmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import studentressourcemanagementsystem.POJO.Paiement;
import studentressourcemanagementsystem.constents.AppConstant;
import studentressourcemanagementsystem.rest.PaiementRest;
import studentressourcemanagementsystem.service.PaiementService;
import studentressourcemanagementsystem.utils.AppUtils;

import java.util.List;
import java.util.Map;

@RestController
public class PaiementRestImpl implements PaiementRest {

    @Autowired
    private PaiementService paiementService;

    @Override
    public ResponseEntity<?> save(Map<String, String> request) {
        try {
           return this.paiementService.savePaiement(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return AppUtils.getResponseMessage(AppConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Paiement>> get() {
        return this.paiementService.getAll();
    }

    @Override
    public ResponseEntity<Paiement> getOne(Long id) {
        return this.paiementService.getOne(id);
    }

    @Override
    public ResponseEntity<?> update(Map<String, String> request) {
        try {
            return this.paiementService.updatePaiement(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return AppUtils.getResponseMessage(AppConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
