/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it250.dao;

import it250.entity.Korisnik;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Workbench
 */
public class KorisnikDaoImpl implements KorisnikDao{
    
    @Inject
    Session session;

    @Override
    public List<Korisnik> getListaKorisnika() {
        return session.createCriteria(Korisnik.class).list();
    }

    @Override
    public void addKorisnik(Korisnik k) {
        session.persist(k);
    }

    @Override
    public Korisnik nadji(int id) {
        return (Korisnik) session.createCriteria(Korisnik.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
    
}
