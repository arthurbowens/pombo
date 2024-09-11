package br.sc.senac.pombo.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private String id;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Pruu> pruus;

    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "O email deve ser válido.")
    @Column(unique = true)
    private String email;

    @NotBlank
    @CPF
    @Column(unique = true)
    private String cpf;


    @Enumerated(EnumType.STRING)
    private PerfilAcesso perfilAcesso = PerfilAcesso.USER;

    @CreationTimestamp
    private LocalDate createdAt;
}