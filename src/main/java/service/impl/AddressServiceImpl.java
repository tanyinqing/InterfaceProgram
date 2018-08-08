package service.impl;

import dao.GenericDao;
import model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.AddressService;

@Service
public class AddressServiceImpl extends GenericServiceImpl<Address, Integer> implements AddressService {
    //    值的实例化  自动装配
    @Override
    @Autowired
    @Qualifier("addressDaoImpl")  //适配是那一个对象
    void setGenericDao(GenericDao<Address, Integer> genericDao) {
        super.genericDao = genericDao;
    }




}
