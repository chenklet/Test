package chapter5mapper.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import chapter5mapper.myenum.SexEnum;

public class SexEnumTypeHandler implements TypeHandler<SexEnum>{

	@Override
	public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
		int id = rs.getInt(columnName);
		return SexEnum.getSexById(id);
	}

	@Override
	public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
		int id = rs.getInt(columnIndex);
		return SexEnum.getSexById(id);
	}

	@Override
	public SexEnum getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		int id = cs.getInt(columnIndex);
		return SexEnum.getSexById(id);
	}

	@Override
	public void setParameter(PreparedStatement ps, int i, SexEnum sexEnum,
			JdbcType jdbcType) throws SQLException {
		ps.setInt(i, sexEnum.getId());
	}

}
