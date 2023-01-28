package studentressourcemanagementsystem.servicelmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentressourcemanagementsystem.POJO.Paiement;
import studentressourcemanagementsystem.POJO.TFEData;
import studentressourcemanagementsystem.constents.AppConstant;
import studentressourcemanagementsystem.dao.PaiementDao;
import studentressourcemanagementsystem.service.PaiementService;
import studentressourcemanagementsystem.service.TFEDataService;
import studentressourcemanagementsystem.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementDao paiementDao;

    @Autowired
    private TFEDataService tfeDataService;

    @Override
    public ResponseEntity<?> savePaiement(Map<String, String> request) {
        try {
            if (valideRequest(request) == true) {
                Paiement p = this.ecxtractMap(request);
                TFEData data = this.tfeDataService.findById(p.getIdTFE());
                p.setTfeData(data);
                this.paiementDao.save(p);
                return AppUtils.getResponseMessage(AppConstant.SAVED_SUCCESSFULLY, HttpStatus.OK);
            } else {
                return AppUtils.getResponseMessage(AppConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AppUtils.getResponseMessage(AppConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updatePaiement(Map<String, String> request) {
        try {
            if ((valideRequest(request) == true)) {
                   Paiement p = this.ecxtractMap(request);
                   p.setId(Long.parseLong(request.get("id")));
                   TFEData data = this.tfeDataService.findById(p.getIdTFE());
                   p.setTfeData(data);
                   this.paiementDao.save(p);
                   System.out.println("Reqeust data "+p.toString());
                 return AppUtils.getResponseMessage(AppConstant.UPDATED_SUCCESSFULLY, HttpStatus.OK);

            } else {
               return AppUtils.getResponseMessage(AppConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return AppUtils.getResponseMessage(AppConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Paiement>> getAll() {
        try {
            List<Paiement> paiementList = this.paiementDao.findAll();
            return new ResponseEntity<List<Paiement>>(paiementList, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<List<Paiement>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Paiement> getOne(Long id) {
        try {
            Paiement paiement = this.paiementDao.findPaiementById(id);
            return new ResponseEntity<Paiement>(paiement, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<Paiement>(new Paiement(), HttpStatus.BAD_REQUEST);
    }

    private boolean valideRequest(Map<String, String> request) {
        return request.containsKey("montant") &&
                request.containsKey("NoVersement") &&
                request.containsKey("receptionniste") &&
                request.containsKey("description") &&
                request.containsKey("idTFE");
    }


    private Paiement ecxtractMap(Map<String, String> request) {
        return Paiement.builder()
                .id(Long.parseLong(request.get("id")))
                .montant(Double.parseDouble(request.get("montant")))
                .NoVersement(request.get("NoVersement"))
                .receptionniste(request.get("receptionniste"))
                .description(request.get("description"))
                .idTFE(Long.parseLong(request.get("idTFE")))
                .build();
    }
}
