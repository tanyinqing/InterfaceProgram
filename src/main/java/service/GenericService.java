package service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends Serializable, N extends Serializable>{
    // create
    void create(T t);

    // remove
    void remove(N id);

    // update
    void update(T t);

    // queryAll
    List<T> queryAll();
    List<T> queryAll(String statement, Object parameter);

    T queryById(N id);

    void removeSelected(N[] ids);
    T queryOne(String statement, Object parameter);
    List<T> queryList(String statement, Object parameter);
}
