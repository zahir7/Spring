package test.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;



public class UserDAO extends JdbcDaoSupport implements DAO {
	@Override
	public List getUserList() throws DataAccessException {
		 RowMapper rowMapper = new UserRowMapper();
	        //SQL실행
	     return getJdbcTemplate().query("select * from test", rowMapper);
	}

	@Override
	public UserDTO getUser(Integer userid) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	protected class UserRowMapper implements RowMapper {

        private List userList = new ArrayList();

        public List getResults() {
            return userList;
        }

        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
           //ResultSet에서 오브젝트로 다시 채워넣음
            UserDTO user = new UserDTO();
            user.setNum(rs.getInt("num"));
            user.setName(rs.getString("name"));
            user.setReg(rs.getTimestamp("reg"));
            return user;
        }
    }
}








