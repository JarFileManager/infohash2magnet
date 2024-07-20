package com.infohash2magnet.converterApp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    @Value("${magnet.prefix.string}")
    private String magnetPrefix;

    public String convertInfoHashToMagnet(String infoHash){
        if(infoHash.isEmpty()){
            return "";
        }

        return magnetPrefix + infoHash;
    }
}
