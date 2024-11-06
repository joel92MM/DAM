package org.ejercicios.dao;

import org.ejercicios.utils.JpaUtil;

import javax.persistence.*;

public class PasajeroDAO {
    EntityManager em;

    public long contarPasajerosEnVuelo(String codVuelo) {
        em = JpaUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("SELECT COUNT(*) FROM Pasajero p WHERE p.codVuelo = :codVuelo");
        query.setParameter("codVuelo", codVuelo);
        long count = (long) query.getSingleResult();
        em.close();
        return count;
    }
}
