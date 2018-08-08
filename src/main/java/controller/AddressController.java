package controller;

import model.Address;
import model.DownData;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AddressService;
import service.UserService;

import java.util.List;

/**
 * ������
 * ע�ⷽʽ��д
 * ����ӳ��
 */
@Controller
@RequestMapping("address")
public class AddressController extends BaseController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    @RequestMapping("create")
    @ResponseBody
    private DownData create(Address address) {
        User user = userService.queryById(address.getUserId());
        if (user.getAddressId() > 0) {
            request.setAttribute("message", "User has address.");
            DownData data=new DownData("1","���û��Ѿ��е�ַ!","true","");
            return data;
        }
        addressService.create(address);
        user.setAddressId(address.getId());
        userService.update(user);
        DownData data=new DownData("1","��ӵ�ַ�ɹ�!","true",user);
        return data;
    }

    @RequestMapping("queryAll")
    @ResponseBody
    private DownData queryAll() {
        List<Address> addresses=addressService.queryAll();
        DownData data=new DownData(String.valueOf(addresses.size()),"��ѯ�ɹ�!","true",addresses);
        return data;
    }

    @RequestMapping("addressUser/{id}")
    @ResponseBody
    private DownData addressUser(@PathVariable int id) {
        DownData data=new DownData("1","��ѯ�ɹ�!","true",addressService.queryOne("addressUser", id));
        return data;
    }


}
