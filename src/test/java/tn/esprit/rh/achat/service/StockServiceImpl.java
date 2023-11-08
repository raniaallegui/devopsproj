package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StockServiceImplTest {
    @InjectMocks

    public StockServiceImpl StockServiceImp;
    @Mock
    public StockRepository stockRepository;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void TestAddStock() {
        Stock stock = new Stock();

        when(stockRepository.save(stock)).thenReturn(stock);

        Stock result = StockServiceImp.addStock(stock);

        assertEquals(stock, result);
    }
    @Test
    void testDeleteProduit() {
        Long produitId = 1L;
        doNothing().when(stockRepository).deleteById(produitId);
        StockServiceImp.deleteStock(produitId);
        verify(stockRepository).deleteById(produitId);
    }
    @Test
    void testRetrieveAllProduits() {
        // Créer une liste fictive de stocks pour simuler la réponse de la base de données
        List<Stock> stocks = new ArrayList<>();
        Stock stock1 = new Stock();
        Stock stock2 = new Stock();
        stocks.add(stock1);
        stocks.add(stock2);

        // Configurer le mock pour que stockRepository.findAll renvoie la liste fictive de stocks
        when(stockRepository.findAll()).thenReturn(stocks);


        List<Stock> result = StockServiceImp.retrieveAllStocks();


        verify(stockRepository).findAll();


        assertEquals(stocks, result);
    }
}