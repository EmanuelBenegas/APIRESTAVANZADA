package Apirest.services;

import Apirest.persistence.MensajeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lcc on 22/11/2016.
 */
@Service
public class MensajeService {
    @Autowired
    MensajeDAO mensdao;

    public  MensajeService(MensajeDAO mens){
        this.mensdao=mens;
    }
}
