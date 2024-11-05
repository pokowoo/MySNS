package dao;
import java.sql.*;
import javax.naming.NamingException;
import util.*;
public class UserDAO {
	public boolean insert(String uid, String upass, String uname) throws NamingException, SQLException {
	Connection conn = ConnectionPool.get();
	PreparedStatement stmt = null;
	try {
		String sql = "INSERT INTO user(id, password, name) VALUES(?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, uid);
		stmt.setString(2, upass);
		stmt.setString(3, uname);
		int count = stmt.executeUpdate();
		return (count == 1) ? true : false;
	} finally {
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
		}
	}
public boolean exists(String uid) throws NamingException, SQLException {
	Connection conn = ConnectionPool.get();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		String sql = "SELECT id FROM user WHERE id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, uid);
		rs = stmt.executeQuery();
	return rs.next();
	} finally {
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (conn != null) conn.close();
	}
}
public boolean delete(String uid) throws NamingException, SQLException {
	Connection conn = ConnectionPool.get();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		String sql = "DELETE FROM user WHERE id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, uid);
		int count = stmt.executeUpdate();
		return (count == 1) ? true : false;
	} finally {
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (conn != null) conn.close();
	}
}
}