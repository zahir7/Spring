package test.jdbc;

import java.util.List;

import model.Team;

import org.springframework.dao.DataAccessException;

public interface DAO {
	List getUserList()throws DataAccessException;
	UserDTO getUser(Integer userid) throws DataAccessException;
}
