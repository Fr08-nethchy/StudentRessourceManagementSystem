package studentressourcemanagementsystem.service;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import studentressourcemanagementsystem.POJO.TFEData;

import java.util.List;
import java.util.Map;

public interface TFEDataService {

    ResponseEntity<?> saveData( Map<String,String> request);
    ResponseEntity<?> updateData( Map<String,String> request);
    ResponseEntity<?> delete(Long id);
    ResponseEntity<List<TFEData>> getAll();
    ResponseEntity<TFEData> getOne(Long id);
    TFEData findById(Long id);



}
