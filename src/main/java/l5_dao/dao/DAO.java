package l5_dao.dao;

import java.io.Serializable;
import java.sql.SQLException;

public interface DAO<T>{

    T save (T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    boolean update (T t) throws SQLException;

    boolean delete (Serializable id) throws SQLException;
}
