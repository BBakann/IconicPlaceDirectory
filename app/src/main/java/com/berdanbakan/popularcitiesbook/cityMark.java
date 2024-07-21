package com.berdanbakan.popularcitiesbook;

import java.io.Serializable;

public class cityMark implements Serializable {
    String name;
    String city;
    int image; // her bir görsele birtane integer atandığı için int denir.

    public cityMark(String name, String city, int image){
        this.city=city;
        this.name=name;
        this.image= image;

    }

}
