package service;

import entity.Serial;

import java.util.List;

public interface ISerialService {
    Serial addSerial(Serial serial);

    Serial getOneSerialByName_rus(String name_rus);

    Serial getOneSerialByName_eng(String name_eng);

    List<Serial> getAllSerials();




}
