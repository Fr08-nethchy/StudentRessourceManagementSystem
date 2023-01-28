package studentressourcemanagementsystem.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentressourcemanagementsystem.POJO.TFEData;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/tfedata")
public interface TFEDataRest {

    @PostMapping(path = "/save")
    ResponseEntity<?> save(@RequestBody(required = true)Map<String, String> request);

    @PutMapping(path = "/update")
    ResponseEntity<?> update(@RequestBody(required = true)Map<String, String> request);

    @GetMapping(path = "/get")
    ResponseEntity<List<TFEData>> getAll();


    @DeleteMapping(path = "/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id);

    @GetMapping(path = "/{id}")
    ResponseEntity<TFEData> getOne(@PathVariable("id") Long id);
}
