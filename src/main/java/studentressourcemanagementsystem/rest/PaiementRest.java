package studentressourcemanagementsystem.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentressourcemanagementsystem.POJO.Paiement;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/paiement")
public interface PaiementRest {

    @PostMapping(path = "/save")
    ResponseEntity<?> save(@RequestBody(required = true) Map<String, String> request);


    @GetMapping(path = "/get")
    ResponseEntity<List<Paiement>> get();

    @GetMapping(path = "/{id}")
    ResponseEntity<Paiement> getOne(@PathVariable("id") Long id);

    @PutMapping(path = "/update")
    ResponseEntity<?> update(@RequestBody(required = true) Map<String, String> request);

}
