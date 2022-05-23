package com.company;

import java.io.Serializable;

public abstract class Kiosk implements Serializable {
    String name;
    String adress;
    abstract void Output();
    abstract boolean SComent(String serch);
}

