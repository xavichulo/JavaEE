package core;

import java.sql.ResultSet;
import java.sql.Statement;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create conection
		//ConnectDatabase cd = new ConnectDatabase();
		//cd.toString();
		
		
		//System.out.println(cd.getConexion());
		//System.out.println(cd.GetConnection());

		boolean enc = queryLogin("user2","password2");
		System.out.println(enc);
		
	}
	
	
	
	public static  boolean queryLogin(String user, String pass){
		boolean enci=false;
		//CONNECT DATABASE
		try{
			ConnectDatabase db = new ConnectDatabase();
			System.out.println(db.toString());
			System.out.println(db.toString());
			Statement st = (Statement)db.getConexion().createStatement();
			String query = "SELECT * FROM users" ;
			
			String u="user2";String p="password2";
			String query2 = "SELECT name,password FROM users WHERE name ='"+ u +"' AND password='"+ p+"'";
			
			
			ResultSet resul = st.executeQuery(query2);
			while(resul.next()){
				System.out.println("Usuario: "+resul.getString("name") +"\n"+"Password: "+resul.getString("password") );
			}
			enci=true;
			//db.disconnect();
		}catch(Exception e){
			enci=false;
			System.out.println("Error with query2");
		}
		
		return enci;
		
	}
	
	

}
