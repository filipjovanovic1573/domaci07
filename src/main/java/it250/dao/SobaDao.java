package it250.dao;

import it250.entity.Soba;
import java.util.List;

public interface SobaDao {

    public List<Soba> getListaSoba();

    public void addSoba(Soba soba);

}
