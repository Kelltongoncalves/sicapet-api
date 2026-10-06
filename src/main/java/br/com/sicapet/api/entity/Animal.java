package br.com.sicapet.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "animais")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private TipoAnimal tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private SexoAnimal sexo;

    @Column(nullable=false)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="tutor_id", nullable=false)
    private Tutor tutor;

    @Column(nullable=false, length=100)
    private String bairro;

    public Animal() {}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public TipoAnimal getTipo(){return tipo;} public void setTipo(TipoAnimal tipo){this.tipo=tipo;}
    public SexoAnimal getSexo(){return sexo;} public void setSexo(SexoAnimal sexo){this.sexo=sexo;}
    public Integer getQuantidade(){return quantidade;} public void setQuantidade(Integer quantidade){this.quantidade=quantidade;}
    public Tutor getTutor(){return tutor;} public void setTutor(Tutor tutor){this.tutor=tutor;}
    public String getBairro(){return bairro;} public void setBairro(String bairro){this.bairro=bairro;}
}
