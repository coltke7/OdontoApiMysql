package com.api.odonto.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

@Entity
@Table(name = "procedimentos")
public class Procedimentos {

    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "historico_id")
    private Historico historico;

    @Column(name = "procedimentos")
    private String procedimentos;

    public Procedimentos() {

    }

    public Procedimentos(Long id, Historico historico, String procedimentos) {
        this.id = id;
        this.historico = historico;
        this.procedimentos = procedimentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    public String getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(String procedimentos) {
        this.procedimentos = procedimentos;
    }
   
}
