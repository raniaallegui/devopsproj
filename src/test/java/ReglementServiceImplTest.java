import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReglementServiceImplTest {

    @InjectMocks
    private ReglementServiceImpl reglementService;

    @Mock
    private ReglementRepository reglementRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllReglements() {
        // Arrange
        List<Reglement> expectedReglements = new ArrayList<>();
        when(reglementRepository.findAll()).thenReturn(expectedReglements);

        // Act
        List<Reglement> actualReglements = reglementService.retrieveAllReglements();

        // Assert
        assertEquals(expectedReglements, actualReglements);
    }

    @Test
    public void testAddReglement() {
        // Arrange
        Reglement reglement = new Reglement();
        when(reglementRepository.save(reglement)).thenReturn(reglement);

        // Act
        Reglement addedReglement = reglementService.addReglement(reglement);

        // Assert
        assertEquals(reglement, addedReglement);
    }

    @Test
    public void testRetrieveReglement() {
        // Arrange
        Long reglementId = 1L;
        Reglement expectedReglement = new Reglement();
        when(reglementRepository.findById(reglementId)).thenReturn(java.util.Optional.ofNullable(expectedReglement));

        // Act
        Reglement actualReglement = reglementService.retrieveReglement(reglementId);

        // Assert
        assertEquals(expectedReglement, actualReglement);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        // Arrange
        Long factureId = 1L;
        List<Reglement> expectedReglements = new ArrayList<>();
        when(reglementRepository.retrieveReglementByFacture(factureId)).thenReturn(expectedReglements);

        // Act
        List<Reglement> actualReglements = reglementService.retrieveReglementByFacture(factureId);

        // Assert
        assertEquals(expectedReglements, actualReglements);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        // Arrange
        Date startDate = new Date();
        Date endDate = new Date();
        float expectedChiffreAffaire = 100.0f;
        when(reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(expectedChiffreAffaire);

        // Act
        float actualChiffreAffaire = reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);

        // Assert
        assertEquals(expectedChiffreAffaire, actualChiffreAffaire);
    }
}
