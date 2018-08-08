package dao.impl;

import dao.AddressDao;
import model.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address,Integer> implements AddressDao {

}
