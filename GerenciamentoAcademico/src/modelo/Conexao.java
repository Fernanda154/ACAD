package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;
public class Conexao {
	   public  Connection createConnection() throws SQLException{
	        String url = "jdbc:mysql://localhost:3306/gerenciamento_academico"; //Nome da base de dados
	        String user = "root"; //nome do usu�rio do MySQL
	        String password = "cabeloloco154"; //senha do MySQl
	        Connection conexao = null;
	        conexao = DriverManager.getConnection(url, user, password);
			 String sql = "INSERT INTO loja (nome,sobrenome,idade,salario) VALUES ('Mario','Corleone','28','2322.39')";
			 //Prepara a instru��o SQL
			 PreparedStatement ps = conexao.prepareStatement(sql);
			 //Executa a instru��o SQL
			 ps.execute();
	        return conexao;
	    }
	  
}

