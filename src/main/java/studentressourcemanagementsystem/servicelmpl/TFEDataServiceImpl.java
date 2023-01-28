package studentressourcemanagementsystem.servicelmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import studentressourcemanagementsystem.POJO.TFEData;
import studentressourcemanagementsystem.constents.AppConstant;
import studentressourcemanagementsystem.dao.TFEDataDao;

import studentressourcemanagementsystem.service.TFEDataService;
import studentressourcemanagementsystem.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TFEDataServiceImpl implements TFEDataService {

    @Autowired
    private TFEDataDao tfeDdataDao;


    @Override
    public ResponseEntity<?> saveData(Map<String, String> request) {

        try {
            if (isFieldValid(request)) {
                this.tfeDdataDao.save(extractMapToObject(request));
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
    public ResponseEntity<?> updateData(Map<String, String> request) {
        try {
            if (isFieldValid(request)) {
                this.tfeDdataDao.save(extractMapToObject(request));
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
        try {
           this.tfeDdataDao.deleteById(id);
            return AppUtils.getResponseMessage(AppConstant.DELETED_MESSAGE,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return AppUtils.getResponseMessage(AppConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<TFEData>> getAll() {
        try {
            List<TFEData> dataList = this.tfeDdataDao.findAll();
            return new ResponseEntity<List<TFEData>>(dataList, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<TFEData>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<TFEData> getOne(Long id) {
        try {
           TFEData data = this.tfeDdataDao.findById(id).orElse(null);
            return new ResponseEntity<TFEData>(data, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<TFEData>(new TFEData(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public TFEData findById(Long id) {
        return this.tfeDdataDao.findTFEDataById(id);
    }


    private boolean isFieldValid(Map<String, String> request) {
        return request.containsKey("cfe") &&
                request.containsKey("nom_etud") &&
                request.containsKey("prenom_etud") &&
                request.containsKey("matricule") &&
                request.containsKey("nif_ninu_cin") &&
                request.containsKey("promotion") &&
                request.containsKey("option") &&
                request.containsKey("telephonne_etud") &&
                request.containsKey("email_etud") &&
                request.containsKey("sexe") &&
                request.containsKey("intitule_mem") &&
                request.containsKey("nom_encadreur") &&
                request.containsKey("telephonne_encadreur") &&
                request.containsKey("email_encadreur") &&
                request.containsKey("code_projet");
    }

    private TFEData extractMapToObject(Map<String, String> request) {
        return TFEData.builder()
                .id(Long.parseLong(request.get("id")))
                .cfe(request.get("cfe"))
                .nom_etud(request.get("nom_etud"))
                .prenom_etud(request.get("prenom_etud"))
                .matricule(request.get("matricule"))
                .nif_ninu_cin(request.get("nif_ninu_cin"))
                .promotion(request.get("promotion"))
                .telephonne_etud(request.get("telephonne_etud"))
                .email_etud(request.get("email_etud"))
                .sexe(request.get("sexe"))
                .option(request.get("option"))
                .intitule_mem(request.get("intitule_mem"))
                .nom_encadreur(request.get("nom_encadreur"))
                .telephonne_encadreur(request.get("telephonne_encadreur"))
                .email_encadreur(request.get("email_encadreur"))
                .code_projet(request.get("code_projet"))
                .build();
    }
}
