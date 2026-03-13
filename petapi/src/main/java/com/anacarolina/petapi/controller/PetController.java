package com.anacarolina.petapi.controller;

import org.springframework.web.bind.annotation.*;

import com.anacarolina.petapi.dto.PetRequestDTO;
import com.anacarolina.petapi.dto.PetResponseDTO;
import com.anacarolina.petapi.model.Pet;
import com.anacarolina.petapi.service.PetService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pets")
public class PetController {

    private final PetService service;
	

    public PetController(PetService service){
        this.service = service;
    }

    @PostMapping
    public PetResponseDTO criar(@RequestBody PetRequestDTO dto) {

        Pet pet = new Pet();
        pet.setNome(dto.getNome());
        pet.setIdade(dto.getIdade());
        pet.setDono(dto.getDono());
        pet.setEspecie(dto.getEspecie());

        service.salvar(pet);
        
        PetResponseDTO pet2 = new PetResponseDTO();
        pet2.setNome(pet.getNome());
        pet2.setIdade(pet.getIdade());
        pet2.setDono(pet.getDono());
        pet2.setEspecie(pet.getEspecie());
        
        return pet2;
    }
    @GetMapping
    public List<Pet> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pet buscar(@PathVariable Long id){
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
        
        @PutMapping("/{id}")
        public Pet atualizar(@PathVariable Long id, @RequestBody Pet pet) {
            return service.atualizar(id, pet);
    }
}