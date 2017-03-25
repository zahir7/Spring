package test.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		UserDTO user = new UserDTO();
		user.setNum(rs.getInt("num"));
		user.setName(rs.getString("name"));
		user.setReg(rs.getTimestamp("reg"));
		return user;
	}

}
