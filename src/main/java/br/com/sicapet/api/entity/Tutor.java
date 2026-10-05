package br.com.sicapet.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tutores", uniqueConstraints = {
    @UniqueConstraint(name = "uk_tutor_cpf", columnNames = "cpf"),
    @UniqueConstraint(name = "uk_tutor_email", columnNames = "email")
})
public class Tutor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length=150) private String nome;
    @Column(nullable=false, length=14) private String cpf;
    @Column(nullable=false, length=20) private String telefone;
    @Column(nullable=false, length=150) private String email;
    @Column(nullable=false, length=100) private String bairro;

    public Tutor() {}
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
    public String getCpf(){return cpf;} public void setCpf(String cpf){this.cpf=cpf;}
    public String getTelefone(){return telefone;} public void setTelefone(String telefone){this.telefone=telefone;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public String getBairro(){return bairro;} public void setBairro(String bairro){this.bairro=bairro;}
}
