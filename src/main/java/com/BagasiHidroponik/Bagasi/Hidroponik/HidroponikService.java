package com.BagasiHidroponik.Bagasi.Hidroponik;

import java.util.List;
/**
 *
 * @author Yapart
 */
public interface HidroponikService {
    Costumer addCostumer(Costumer costumer);
    Costumer getCostumerById(int id);
    void updateCostumer(Costumer costumer);
    void deleteCostumerById(int id);
    List<Costumer> getAllCostumer();
}
