package mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=todo_app;encrypt=false";
	public static final String USER = "sa";
	public static final String PASS = "12345678";

	/**
	 * esse método devolve uma conexão <code>static<code>:Diz que eu posso chamar
	 * esse método sem criar uma instacia dessa classe. não é necessário criar um
	 * objeto de classe ConnectionFatory,para poder excuta=lo é como se fosse um
	 * método global,não é muito usual, vai depender de cada projeto.
	 *
	 * @return conexão com banco de dados.
	 * 
	 */
	public static Connection getConnection() {
		// try-cat: é uma forma de pegar erros que podem acontecer e fazer
		// um tratamento. faz tratamento de exeção/erro. no try se coloca todo
		// código que é passivel de erro.
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão com o banco de dados", e);
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			// se a conexão existir,feche-a
			if (connection != null) {
				connection.close();
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão com o banco de dados", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			closeConnection(connection);

			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão com o banco de dados", e);
		}

	}

	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			closeConnection(connection, statement);

			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão com o banco de dados", e);
		}

	}
}
