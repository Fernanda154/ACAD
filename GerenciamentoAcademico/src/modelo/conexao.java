package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;
public class conexao {
	   public  Connection createConnection() throws SQLException{
	        String url = "jdbc:mysql://localhost:3306/gerenciamento_academico"; //Nome da base de dados
	        String user = "root"; //nome do usuário do MySQL
	        String password = "cabeloloco154"; //senha do MySQl
	        Connection conexao = null;
	        conexao = DriverManager.getConnection(url, user, password);
			 String sql = "INSERT INTO loja (nome,sobrenome,idade,salario) VALUES ('Mario','Corleone','28','2322.39')";
			 //Prepara a instrução SQL
			 PreparedStatement ps = conexao.prepareStatement(sql);
			 //Executa a instrução SQL
			 ps.execute();
	        return conexao;
	    }
	  
}

