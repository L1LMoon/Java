package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpostTest {

    @org.junit.jupiter.api.Test
    void chekTisk() {
        assertEquals(false,new Spost(new Date(2022-1900, 05-1, 6), 19, 600).ChekTisk(601));
    }
}
