package com.hibernate.introduccion.controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.introduccion.modelo.Mascota;

@RestController("/")
public class MascotaController {

    // ATRIBUTOS
    private SessionFactory factory;

    // CONSTRUCTOR
    public MascotaController() {
        // Crear objeto que permita fabricar sesiones
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Mascota.class)
                .buildSessionFactory();
    }

    @GetMapping
    public String getMascotas() {
        return "Hola mundo utilizando Spring Boot";
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    // ACCIONES
    public String create(String nombre, String apellido, String raza, String foto, String observacion) {
        String resp = "";
        Session session = openSession();
        try {
            Mascota mascota = new Mascota(nombre, apellido, raza, foto, observacion);
            session.persist(mascota);
            session.getTransaction().commit();
            resp = "Mascota creada con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        session.close();
        return resp;
    }

    public List<Mascota> getXRaza(String raza) {
        List<Mascota> mascotas = new ArrayList<>();
        Session session = openSession();
        try {
            mascotas = session.createQuery("from Mascota where raza = :param_raza", Mascota.class)
                    .setParameter("param_raza", raza)
                    .list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mascotas;
    }

}
