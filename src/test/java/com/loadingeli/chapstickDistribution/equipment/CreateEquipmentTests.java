package com.loadingeli.chapstickDistribution.equipment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateEquipmentTests {

    @Test
    public void CreateSingleCustomer() {
        Equipment firstEquipment = new Equipment(1L,"Backhoe",1234456);

        Assertions.assertEquals("Backhoe", firstEquipment.getType());
    }
}
