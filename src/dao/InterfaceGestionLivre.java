package dao;

import model.Livre;

import java.util.List;

public interface InterfaceGestionLivre {
    public List<Livre> GetAllProduits();
    public Livre GetLivretByID(int idpdt);
    public void insert(Livre categorie);
    public void delete(int idpdt);
    public void update(Livre livre);

}
