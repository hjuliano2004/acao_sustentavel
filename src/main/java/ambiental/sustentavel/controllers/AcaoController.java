package ambiental.sustentavel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ambiental.sustentavel.dtos.AcaoRequest;
import ambiental.sustentavel.dtos.AcaoResponse;
import ambiental.sustentavel.enums.CategoriaAcao;
import ambiental.sustentavel.services.AcaoServices.AcaoServicesIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("acao")
public class AcaoController {

    @Autowired
    private AcaoServicesIn service;

    @GetMapping
    public List<AcaoResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public AcaoResponse findById(@PathVariable @Min(1) Long id){
        return service.findById(id); 
    }

    @PostMapping
    public AcaoResponse post(@Valid @RequestBody AcaoRequest acaoRequest) {

        return service.post(acaoRequest);
    }
    
    @PutMapping("{id}")
    public AcaoResponse put(@PathVariable @Min(1) Long id, @Valid @RequestBody AcaoRequest acaoRequest){
        return service.put(id, acaoRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id){

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{tipo}")
    public List<AcaoResponse> porCategoria(@PathVariable CategoriaAcao tipo){

        return service.findByCategoriAcao(tipo);
    }
}
