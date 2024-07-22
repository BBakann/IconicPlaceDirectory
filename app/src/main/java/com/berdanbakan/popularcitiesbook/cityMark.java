package com.berdanbakan.popularcitiesbook;

import java.io.Serializable;

public class cityMark implements Serializable {
    String name;
    String city;
    int image; // her bir görsele birtane integer atandığı için int denir.

    String info;

    public cityMark(String name, String city, int image,String info){
        this.city=city;
        this.name=name;
        this.image= image;
        this.info=info;

    }

}
