package dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

class InsertPlayer extends SqlUpdate {

    public InsertPlayer(DataSource ds) {
        super(ds, "INSERT INTO player(PLAYER_ID,name, team_id) VALUES(PLAYER_ID_SEQ.NEXTVAL, ?, ?)");
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
        compile();
    }
}
