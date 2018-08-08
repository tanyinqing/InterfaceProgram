package service.impl;

import dao.GenericDao;
import service.GenericService;

import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<T extends Serializable, N extends Serializable> implements GenericService<T, N> {
    GenericDao<T, N> genericDao;//Book实现类

    abstract void setGenericDao(GenericDao<T, N> genericDao);

    @Override
    public void create(T t) {
        genericDao.create(t);
    }

    @Override
    public void remove(N id) {
        genericDao.remove(id);
    }

    @Override
    public void update(T t) {
        genericDao.update(t);
    }

    @Override
    public List<T> queryAll() {
        return genericDao.queryAll();
    }

    @Override
    public List<T> queryAll(String statement, Object parameter) {
        return genericDao.queryAll(statement,parameter);
    }

    @Override
    public T queryById(N id) {
        return genericDao.queryById(id);
    }

    @Override
    public void removeSelected(N[] ids) {
        genericDao.removeSelected(ids);
    }

    @Override
    public T queryOne(String statement, Object parameter) {
        return genericDao.queryOne(statement, parameter);
    }

    @Override
    public List<T> queryList(String statement, Object parameter) {
        return genericDao.queryList(statement, parameter);
    }
}
