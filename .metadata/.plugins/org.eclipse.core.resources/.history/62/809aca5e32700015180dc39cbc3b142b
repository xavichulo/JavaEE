/**
 * 
 */
package core;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author jafamo
 *
 */
public class ConnectDatabase {

	private String user;
	private String password;
	private String url;
	private String db;
	private Connection conexion = null;
	private String server;

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
	public String toString(){
		String res="User:"+getUser()+"\nPass:"+this.getPassword()+"\nURL:"+this.getUrl()+"\nServer:"+this.getServer();
		res= res+"\nDB:"+this.getDb()+"\nConexion"+this.getConexion();
		return res;
	}


	/**
	 * Constructor
	 */
	public ConnectDatabase() {
		this.user = "vagrant";
		this.password = "vagrant";
		this.db = "vagrant";
		this.server = "192.168.56.101";
		this.url = "jdbc:mysql://" + server + "/" + db;
		conexion = this.GetConnection();
	}

	public ConnectDatabase(String server, String user, String password, String db, String url) {
		this.server = server;
		this.user = user;
		this.password = password;
		this.db = db;
		this.url = "jdbc:mysql://" + server + "/" + db;
	}

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

	public void disconnect() throws SQLException {
		conexion.close();

	}

}
