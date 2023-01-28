package studentressourcemanagementsystem.restlmpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import studentressourcemanagementsystem.POJO.TFEData;
import studentressourcemanagementsystem.constents.AppConstant;
import studentressourcemanagementsystem.rest.TFEDataRest;
import studentressourcemanagementsystem.service.TFEDataService;
import studentressourcemanagementsystem.utils.AppUtils;

import java.util.List;
import java.util.Map;

@RestController
public class TFEDataRestImpl implements TFEDataRest {

    private TFEDataService tfeDataService;

    public TFEDataRestImpl(TFEDataService tfeDataService) {
        this.tfeDataService = tfeDataService;
    }

    @Override
    public ResponseEntity<?> save(Map<String, String> request) {
       try {
          return this.tfeDataService.saveData(request);
       }catch (Exception e){
           e.printStackTrace();
       }
       return  AppUtils.getResponseMessage(AppConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> update(Map<String, String> request) {
        try {
            return this.tfeDataService.updateData(request);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  AppUtils.getResponseMessage(AppConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<TFEData>> getAll() {
        return this.tfeDataService.getAll();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        this.tfeDataService.delete(id);
        return AppUtils.getResponseMessage(AppConstant.DELETED_MESSAGE,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TFEData> getOne(Long id) {
        return this.tfeDataService.getOne(id);
    }
}
