package mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Project;

public class ProjectDAO {

	public void save(Project project) {
		String sql = "INSERT INTO project ( name,description,createdAt,updatedAt) VALUES (?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));

			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao salvar o Projeto", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void update(Project project) {

		String sql = "UPDATE project SET name= ?, description = ?, createdAt =?,updatedAt = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement(sql);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getCreatedAt().getTime()));
			statement.setInt(5, project.getId());

			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar o Projeto", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public List<Project> getall() {
		String sql = "SELECT * FROM project";

		List<Project> projects = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		// classe que vai recuperar os dados do banco de dados

		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			// enquento existir dados no banco de dados
			while (resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreatedAt(resultSet.getDate("createdAt"));
				project.setUpdatedAt(resultSet.getDate("updatedAt"));
				// adiciono o contato recuperado, a lista de contos
				projects.add(project);
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar o Projeto", e);

		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
		return projects;

	}

	public void removeById(int idProject) {
		String sql = "DELETE FROM project WHERE id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProject);
		} catch (Exception e) {
			throw new RuntimeException("Erro deletar o Projeto", e);

		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}

	}
}
