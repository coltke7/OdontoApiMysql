	package com.api.odonto.models;
	
	import java.util.List;
	
	import javax.persistence.*;
	import javax.validation.constraints.NotNull;
	
	
	@Entity
	@Table(name = "historico")
	public class Historico {
	
		
		@Id
		@Column(name = "id",unique = true,updatable = false, nullable = false)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@OneToOne
		@JoinColumn(name = "paciente_id",nullable = false,updatable = false)
		private Paciente paciente;
		
		@ElementCollection
	    @CollectionTable(name = "procedimentos_list", joinColumns = @JoinColumn(name = "paciente_id"))
		@Column(name = "procedimentos")
		private List<String> procimentosRealizados;

		
		public Historico () {
			
		}
		
		public Historico(Long id, Paciente paciente, List<String> procimentosRealizados) {
			this.id = id;
			this.paciente = paciente;
			this.procimentosRealizados = procimentosRealizados;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Paciente getPaciente() {
			return paciente;
		}

		public void setPaciente(Paciente paciente) {
			this.paciente = paciente;
		}

		public List<String> getProcimentosRealizados() {
			return procimentosRealizados;
		}

		public void setProcimentosRealizados(List<String> procimentosRealizados) {
			this.procimentosRealizados = procimentosRealizados;
		}
		
	
	
	
}
