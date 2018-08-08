package service;

import model.User;

public interface UserService extends GenericService<User, Integer> {

    /**
     *
     * @param user
     * @return boolean 注册结果
     */
    boolean signUp(User user);

    User singIn(User user);
}
