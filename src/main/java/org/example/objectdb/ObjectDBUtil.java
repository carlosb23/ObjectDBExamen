package com.example.practicaobjectdbexamen.objectdb;

import lombok.Getter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utilidad para la gestión de la EntityManagerFactory en el contexto de ObjectDB.
 * Proporciona una instancia estática de EntityManagerFactory para ser utilizada en la aplicación.
 *
 */
public class ObjectDBUtil {

    // La instancia estática de EntityManagerFactory para la aplicación.
    @Getter
    private final static EntityManagerFactory entityManagerFactory;

    static {
        // Se inicializa la EntityManagerFactory al cargar la clase.
        entityManagerFactory = Persistence.createEntityManagerFactory("data.odb");
    }
}
