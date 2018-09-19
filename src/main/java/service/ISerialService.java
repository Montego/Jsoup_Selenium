package service;

import entity.Serial;

import java.util.List;

public interface ISerialService {
    Serial addSerial(Serial serial);

//    Serial getOneSerialByRusName(String name_rus);
//
//    Serial getOneSerialByEngName(String name_eng);

    List<Serial> getAllSerials();




}
