package org.example;

import org.example.domain.Cliente;
import org.example.domain.ClienteDAO;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            // Crear clientes de ejemplo
            Cliente cliente1 = new Cliente("Paco", 1000L, "Activo");
            Cliente cliente2 = new Cliente("Jose", 1500L, "Activo");
            Cliente cliente3 = new Cliente("Leo", 800L, "Inactivo");
            Cliente cliente4 = new Cliente("Carlos", 0L, "Activo");
            Cliente cliente5 = new Cliente("Dani", 1200L, "Inactivo");

            // Insertar clientes en la base de datos
            clienteDAO.insertarCliente(cliente1);
            clienteDAO.insertarCliente(cliente2);
            clienteDAO.insertarCliente(cliente3);
            clienteDAO.insertarCliente(cliente4);
            clienteDAO.insertarCliente(cliente5);

            System.out.println("");
            System.out.println("Clientes insertados en la base de datos" + cliente4);

        } catch (Exception e) {
        throw new RuntimeException(e);
        }

        System.out.println("");

        System.out.println("Cliente con id asignado en el main en este caso el 4:");
        System.out.println("");
        clienteDAO.getCliente(4L);

        System.out.println("Mejores Clientes Activos segun sun numero de venta");
        System.out.println("");
        clienteDAO.listarMejoresClientes(3L);

        System.out.println("");
        clienteDAO.estadisticas();



    }
}