package org.example.domain;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    private String nombreCliente;

    private Long totalVentas;

    private String estado;

    // Constructor, getters y setters
    public Cliente() {
    }

    public Cliente(String nombreCliente, Long totalVentas, String estado) {
        this.nombreCliente = nombreCliente;
        this.totalVentas = totalVentas;
        this.estado = estado;
    }
}
