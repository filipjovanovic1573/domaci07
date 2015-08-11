/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it250.dao;

import it250.entity.Soba;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 *
 * @author Workbench
 */
public class SobaDaoImpl implements SobaDao{
    
    @Inject
    Session session;

    @Override
    public List<Soba> getListaSoba() {
        return session.createCriteria(Soba.class).list();
        //return null;
    }

    @Override
    public void addSoba(Soba soba) {
        session.persist(soba);
    }
    
}
