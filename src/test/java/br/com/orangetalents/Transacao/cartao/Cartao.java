package br.com.orangetalents.Transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    @Email
    private String email;

    public Cartao(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    @Deprecated
    public Cartao() {}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
