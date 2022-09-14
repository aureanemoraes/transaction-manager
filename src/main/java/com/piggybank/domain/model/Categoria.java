package com.piggybank.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// Qual a diferença do name da Entity e do name da Table?
// O que é um schema?

// @Transient não será salvo, será processado durante a chamada;

// crtl + o
@Getter
@Setter
@Entity(name="categoria")
@Table(name="CATEGORIA", schema="OBJETOS")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME", nullable=false, unique=false)
	private String nome;
	
	@Column(name="DESCRICAO", nullable=false, unique=false)
	private String descricao;
}
