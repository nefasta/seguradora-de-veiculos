package br.udesc.curso.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import br.udesc.curso.enums.Servico;
import lombok.Data;

@Data
@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	//É possível comentar as linhas do JoinTable e Column
	@ElementCollection(targetClass=Servico.class)
	//@JoinTable(name="fornecedor_servico", joinColumns=@JoinColumn(name="fornecedorid"))
	@Column(name="servico", nullable=false)
	@Enumerated(EnumType.STRING)
	private Set<Servico> servicos;
}
