
package it250.dao;

import it250.entity.Korisnik;
import java.util.List;

public interface KorisnikDao {
    public List<Korisnik> getListaKorisnika();
    public Korisnik nadji(int id);
    public void addKorisnik(Korisnik k);
}
