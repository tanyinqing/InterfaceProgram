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
 * 控制器
 * 注解方式来写
 * 请求映射
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
            DownData data=new DownData("1","该用户已经有地址!","true","");
            return data;
        }
        addressService.create(address);
        user.setAddressId(address.getId());
        userService.update(user);
        DownData data=new DownData("1","添加地址成功!","true",user);
        return data;
    }

    @RequestMapping("queryAll")
    @ResponseBody
    private DownData queryAll() {
        List<Address> addresses=addressService.queryAll();
        DownData data=new DownData(String.valueOf(addresses.size()),"查询成功!","true",addresses);
        return data;
    }

    @RequestMapping("addressUser/{id}")
    @ResponseBody
    private DownData addressUser(@PathVariable int id) {
        DownData data=new DownData("1","查询成功!","true",addressService.queryOne("addressUser", id));
        return data;
    }


}
