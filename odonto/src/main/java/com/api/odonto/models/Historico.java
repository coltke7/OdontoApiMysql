	package com.api.odonto.models;
	
	import java.util.List;
	
	import javax.persistence.*;
	import javax.validation.constraints.NotNull;
	
	
	@Entity
	@Table(name = "historico")
	public class Historico {
	
		@Column(name = "id",unique = true,updatable = false, nullable = false)
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@NotNull
		private Long id;
		
		@OneToOne
		@JoinColumn(name = "paciente_id",nullable = false,updatable = false)
		private Paciente paciente;
		
		@ElementCollection
	    @CollectionTable(name = "procedimentos_list", joinColumns = @JoinColumn(name = "historico_id"))
		@Column(name = "procedimentos")
		private List<String> procimentosRealizados;
		
	
	
	
}
