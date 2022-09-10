package com.hibernate.introduccion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduccion.modelo.Mascota;

public class App {
    public static void main(String[] args) {

        // Crear objeto que permita fabricar sesiones
        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Mascota.class)
                .buildSessionFactory();

        // Abrir sesión
        Session session = factory.openSession();

        // Preparar la sesión para transacciones
        session.beginTransaction();
        try {
            /*** Crear objeto ***/
            Mascota mascota_1 = new Mascota("Niño", "Quintero", "Criollo", "http://fake-photo", "Sobrepeso");
            Mascota mascota_2 = new Mascota("Dulce", "Medina", "Bulldog", "http://fake-photo", "Ninguna");
            Mascota mascota_3 = new Mascota("Firulais", "Jimenez", "Criollo", "http://fake-photo", "Agresivo");

            // Guardar los objetos
            session.persist(mascota_1);
            // Enviar los datos a la BD
            session.getTransaction().commit();

            /*** Buscar entidad / registro / mascota ***/
            /*
             * Mascota mascota = session.find(Mascota.class, 1);
             * System.out.println(mascota);
             */
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar sesión
        session.close();

    }

}
