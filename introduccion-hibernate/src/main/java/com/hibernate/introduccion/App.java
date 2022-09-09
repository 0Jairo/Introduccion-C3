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
            // Crear objeto
            Mascota mascota = new Mascota("Roko", "Jimenez", "Criollo", "http://fake-photo", "Ninguna");
            session.persist(mascota);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar sesión
        session.close();

    }

}
