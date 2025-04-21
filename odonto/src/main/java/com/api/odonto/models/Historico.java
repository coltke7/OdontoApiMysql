	package com.api.odonto.models;

	import com.fasterxml.jackson.annotation.*;
	import java.util.Date;
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
		@JoinColumn(name = "paciente_id")
		private Paciente paciente;

		//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
		@JsonBackReference
		@OneToMany(mappedBy = "historico")
		private List<Procedimentos> procedimentos;


//		@ElementCollection
//	    @CollectionTable(name = "procedimentos_list", joinColumns = @JoinColumn(name = "paciente_id"))
//		@Column(name = "procedimentos")
//		private List<String> procimentosRealizados;

		
		@Column(name = "cpfp")
	    private String cpfp;
		
		public String getCpfp() {
			return cpfp;
		}

		public void setCpfp(String cpfp) {
			this.cpfp = cpfp;
		}

		public Historico () {
			
		}
		
		public Historico(Long id, Paciente paciente, List<Procedimentos> procedimentos) {
			this.id = id;
			this.paciente = paciente;
			this.procedimentos = procedimentos;
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

		public List<Procedimentos> getProcimentos() {
			return procedimentos;
		}

		public void setProcedimentos(List<Procedimentos> procedimentos) {
			this.procedimentos = procedimentos;
		}
		
	
	
	
}
