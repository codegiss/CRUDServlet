// Giselle Souza CB3020339
// Lucas Gomes   CB 3021777

import java.util.*;
import java.sql.*;

public class EmpDao {

	public static Connection getConnection(){
		Connection con=null;
		
		try{
			String dbDriver = "com.mysql.cj.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/";
			
			// Database name to access
			String dbName = "CRUDSql?useTimezone=true&serverTimezone=America/Sao_Paulo";
			String dbUsername = "admin";
			String dbPassword = "root";
			Class.forName(dbDriver);
			
			con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		} catch (Exception e) {System.out.println(e);}
		return con;
	}
	
	public static int save(Emp e){
		int status=0;
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user905(e_name,e_password,e_email,e_country) values (?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			
			status=ps.executeUpdate();
			
			con.close();
		} catch(Exception ex) {ex.printStackTrace();}
		
		return status;
	}
	
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update user905 set e_name=?,e_password=?,e_email=?,e_country=? where id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			ps.setInt(5,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		} catch(Exception ex) {ex.printStackTrace();}
		
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from user905 where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		} catch(Exception e) {e.printStackTrace();}
		
		return status;
	}
	
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user905 where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			
			con.close();
		} catch(Exception ex) {ex.printStackTrace();}
		
		return e;
	}
	
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user905");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}