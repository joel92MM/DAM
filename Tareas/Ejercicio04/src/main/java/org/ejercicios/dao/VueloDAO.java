package org.ejercicios.dao;

import org.ejercicios.entidades.Vuelo;
import org.ejercicios.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VueloDAO {
    EntityManager em;
    public List<Vuelo> obtenerTodosLosVuelos() {
        em = JpaUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Vuelo> query = em.createQuery("SELECT v FROM Vuelo v", Vuelo.class);
        List<Vuelo> vuelos = query.getResultList();
        em.close();
        return vuelos;
    }
}
