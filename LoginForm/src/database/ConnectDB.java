package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectDB {
	
	private String user;
	private String password;
	private String url;
	private String db;
	private Connection conexion = null;
	private String server;


	/**
	 * Default constructor without parameters and init.
	 */
	public ConnectDB() {
		this.user = "vagrant";
		this.password = "vagrant";
		this.db = "vagrant";
		this.server = "192.168.56.101";
		this.url = "jdbc:mysql://" + server + ":3306/" + db;
		conexion = this.GetConnection();
	}
	
	/**
	 * This method connect with database and return connection with database.
	 *  
	 * 
	 * @return conexion
	 * 
	 */
	
	public Connection GetConnection() {
		// Connection conexion=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// String server = "jdbc:mysql://server101:3306/user1";
			// String userDB="user1";
			// String passwordDB="user1";
			conexion = DriverManager.getConnection(url, user, password);
			if (conexion != null) {
				System.out.println("Conexion OK!: ");
			}
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, e1, "Error1 ClassNotFoundException with BD " + e1.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e, "Error2 SQLException with  BD " + e.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2, "Error3 connection with BD " + e2.getMessage(),
					JOptionPane.ERROR_MESSAGE);
			conexion = null;
		}
		return conexion;
	}
	
	
	public void queryLogin(String u,String p){
		try{
			
			String queryLogin = "SELECT name,password FROM users WHERE name ='"+ u +"' AND password='"+ p+"'";
			Statement stmt = null; 
			ResultSet rs = null;
			
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(queryLogin);
			
			boolean more = rs.next(); 
			// if user does not exist set the isValid variable to false 
			if (!more) { 
				System.out.println("Sorry, you are not a registered user! Please sign up first");  
				} 
			//if user exists set the isValid variable to true 
			else if (more) { 
				String firstName = rs.getString("name"); 
				String lastName = rs.getString("password"); 
				System.out.println("Welcome " + firstName); 
				} 
			} catch (Exception ex) { 
				System.out.println("Log In failed: An Exception has occurred! " + ex); 
				} 
			
		
		
	}
	
	
	
	
	
	/**
	 * This method disconnect with MySQL.
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {
		conexion.close();
	}
	
	
	/**
	 * Getter and setters
	 */
	
	
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	
	
	
	//Override method toString
		public String toString(){
			String res="User:"+getUser()+"\nPass:"+this.getPassword()+"\nURL:"+this.getUrl()+"\nServer:"+this.getServer();
			res= res+"\nDB:"+this.getDb()+"\nConexion"+this.getConexion();
			return res;
		}
	
}
