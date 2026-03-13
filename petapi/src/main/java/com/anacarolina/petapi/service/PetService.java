package com.anacarolina.petapi.service;

import org.springframework.stereotype.Service;

import com.anacarolina.petapi.model.Pet;
import com.anacarolina.petapi.repository.PetRepository;

import java.util.List;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository){
        this.repository = repository;
    }

    public Pet salvar(Pet pet){
        return repository.save(pet);
    }

    public List<Pet> listar(){
        return repository.findAll();
    }

    public Pet buscar(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
    public Pet atualizar(Long id, Pet petAtualizado) {

        Pet pet = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setNome(petAtualizado.getNome());
        pet.setIdade(petAtualizado.getIdade());
        pet.setDono(petAtualizado.getDono());
        pet.setEspecie(petAtualizado.getEspecie());

        return repository.save(pet);
    }

}