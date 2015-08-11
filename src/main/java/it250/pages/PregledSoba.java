/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it250.pages;

import it250.dao.KorisnikDao;
import it250.dao.SobaDao;
import it250.entity.Korisnik;
import it250.entity.Soba;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Workbench
 */
public class PregledSoba {

    @Inject
    private SobaDao sobaDao;
    
    @Inject
    private KorisnikDao korisnikDao;

    @Property
    private Soba soba;

    @Property
    private List<Soba> listaSoba;
    
    @Property
    private List<Korisnik> listaKorisnika;

    @Property
    private int spratValue;

    @Property
    private Korisnik korisnikValue;
    
    @Property
    private boolean tvValue, internetValue, djakuziValue;

    void onActivate() {
        if (listaSoba == null) {
            listaSoba = new ArrayList<Soba>();
        }
        
        if (listaKorisnika == null) {
            listaKorisnika= new ArrayList<Korisnik>();
        }
        
        listaSoba = (ArrayList<Soba>) sobaDao.getListaSoba();
        listaKorisnika = (ArrayList<Korisnik>) korisnikDao.getListaKorisnika();
    }

    @CommitAfter
    Object onSuccess() {
        Soba s = new Soba();
        s.setSprat(spratValue);
        s.setDjakuzi(djakuziValue);
        s.setInternet(internetValue);
        s.setTv(tvValue);
        s.setKorisnikId(korisnikValue);
        sobaDao.addSoba(s);
        return this;
    }

    public ValueEncoder getEncoder(){
        return new ValueEncoder<Korisnik>() {

            @Override
            public String toClient(Korisnik v) {
                return String.valueOf(v.getId());
            }

            @Override
            public Korisnik toValue(String string) {
                return korisnikDao.nadji(Integer.parseInt(string));
            }
        };
    }
    
    
}

