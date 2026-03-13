package com.anacarolina.petapi.dto;

public class PetResponseDTO {

	private Long id;
    private String nome;
    private int idade;
    private String dono;
    private String especie;

    public PetResponseDTO() {
    }

    public PetResponseDTO(Long id, String nome, int idade, String dono, String especie) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dono = dono;
        this.especie = especie;
    }

    public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getDono() {
        return dono;
    }

    public String getEspecie() {
        return especie;
    }
}
