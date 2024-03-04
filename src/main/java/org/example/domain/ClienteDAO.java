package org.example.domain;

import org.example.DAO;
import org.example.objectdb.ObjectDBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {

    @Override
    public void insertarCliente(Cliente cliente) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void getCliente(Long id) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                System.out.println("Cliente: " + cliente);
            } else {
                System.out.println("Cliente con ID, " + id + " no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void listarMejoresClientes(Long cantidad) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c WHERE c.estado = 'Activo' ORDER BY c.totalVentas DESC", Cliente.class);
            query.setMaxResults(Math.toIntExact(cantidad));
            List<Cliente> mejoresClientes = query.getResultList();
            if (!mejoresClientes.isEmpty()) {
                System.out.println("Los mejores clientes activos son:");
                for (Cliente cliente : mejoresClientes) {
                    System.out.println(cliente);
                }
            } else {
                System.out.println("No se encontraron clientes activos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void estadisticas() {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        try {

            TypedQuery<Long> total = em.createQuery("SELECT SUM(c.totalVentas) FROM Cliente c", Long.class);
            Long totalVentas = total.getSingleResult();


            TypedQuery<Double> promedio = em.createQuery("SELECT AVG(c.totalVentas) FROM Cliente c", Double.class);
            Double promedioVentas = promedio.getSingleResult();


            TypedQuery<Long> clientes = em.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.estado = 'Inactivo' AND c.totalVentas > 0", Long.class);
            Long cantidadClientesInactivos = clientes.getSingleResult();


            System.out.println("Total de ventas entre los clientes: " + totalVentas);
            System.out.println("Promedio de ventas de los clientes: " + promedioVentas);
            System.out.println("Cantidad de clientes inactivos con ventas mayores a 0: " + cantidadClientesInactivos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

