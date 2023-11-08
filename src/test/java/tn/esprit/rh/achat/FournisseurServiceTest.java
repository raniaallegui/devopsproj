package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FournisseurServiceTest {
    @InjectMocks

    public FournisseurServiceImpl FournisseurServiceImp;
    @Mock
    public FournisseurRepository fournisseurRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void TestAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();

        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        Fournisseur result = FournisseurServiceImp.addFournisseur(fournisseur);

        assertEquals(fournisseur, result);
    }
    @Test
    void testDeleteProduit() {
        Long produitId = 1L;
        doNothing().when(fournisseurRepository).deleteById(produitId);
        FournisseurServiceImp.deleteFournisseur(produitId);
        verify(fournisseurRepository).deleteById(produitId);
    }
    @Test
    void testRetrieveAllProduits() {
        // Créer une liste fictive de stocks pour simuler la réponse de la base de données
        List<Fournisseur> fournisseurs = new ArrayList<>();
        Fournisseur fournisseur1 = new Fournisseur();
        Fournisseur fournisseur2 = new Fournisseur();
        fournisseurs.add(fournisseur1);
        fournisseurs.add(fournisseur2);

        // Configurer le mock pour que stockRepository.findAll renvoie la liste fictive de stocks
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);


        List<Fournisseur> result = FournisseurServiceImp.retrieveAllFournisseurs();


        verify(fournisseurRepository).findAll();


        assertEquals(fournisseurs, result);
    }
}
