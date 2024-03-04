package org.example;

import org.example.domain.Cliente;

public interface DAO<T>{
    void insertarCliente(T cliente);
    void getCliente(Long id);
    void listarMejoresClientes(Long cantidad);
    void estadisticas();
}
