package mvc.model;

import java.util.Date;

public class Project {
// Atributos
	private int id;
	private String name;
	private String description;
	private Date createdAt;
	private Date updatedAt;
	//construtor
	public Project(int id, String name, String description, Date createdAt, Date updatedAt) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	// construtor com datas
	
	public Project() {
		this.createdAt=new Date();
		this.updatedAt=new Date();
	}

	//Getters and Setters
	//Métodos de acesso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	//Método toString
	//Retorna uma representação textual do objeto Project
	@Override
	public String toString() {
		return this.name;
		
	}
	
	
}
