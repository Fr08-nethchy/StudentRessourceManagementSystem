package studentressourcemanagementsystem.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class AppUtils {

    public  static ResponseEntity<?> getResponseMessage(String message, HttpStatus httpStatus){
        return new ResponseEntity<>(Map.of("message",message),httpStatus);
    }
}
