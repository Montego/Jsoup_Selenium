package service;

import entity.Serial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SerialRepository;

import java.util.List;

@Service
public class SerialService implements ISerialService {

    private SerialRepository serialRepository;

    @Autowired
    public SerialService(SerialRepository serialRepository) {
        this.serialRepository = serialRepository;
    }


    public Serial addSerial(Serial serial) {
        return serialRepository.save(serial);
    }

    @Override
    public Serial getOneSerialByName_rus(String name_rus) {
        return serialRepository.findByNameRus(name_rus);
    }

    @Override
    public Serial getOneSerialByName_eng(String name_eng) {
        return serialRepository.findByNameEng(name_eng);
    }

    @Override
    public List<Serial> getAllSerials() {
        return serialRepository.findAll();
    }


}
