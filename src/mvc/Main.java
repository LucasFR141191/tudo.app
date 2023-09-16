package mvc;

import mvc.dao.ProjectDAO;
import mvc.dao.TaskDAO;
import mvc.model.Project;

public class Main {
	public static void main(String[] args) {
		TaskDAO taskDAO = new TaskDAO();
	//	taskDAO.getall(projectDAO.getall().get(0).getId()).forEach(System.out::println);
		// cria um novo projeto
//	Project project = new Project();
//	project.setName("Projeto Teste");
//	project.setDescription("Descrição do projeto");

		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.getall().get(0);
		
		taskDAO.removeById(taskDAO.getall(project.getId()).get(0).getId());
		projectDAO.removeById(project.getId());
		
//		for (int i = 0; i < projectDAO.getall().size(); i++) {
//			Project project = new Project()
//			if(project.getId()==1) {
//				project.setName("Projeto de Estudo");
//				project.setDescription("Estudos para as férias");
//				projectDAO.update(project);
//			}
//		}
	//	projectDAO.getall().forEach(project -> {
	//			project.setName("Projeto de Estudo");
	//			project.setDescription("Estudos para as férias");
	//			projectDAO.update(project);
	//	});

//	projectDAO.save(project);

		// cria uma nova tarefa
//	Task task = new Task();
//	task.setIdProject(projectDAO.getall().get(0).getId());
//	task.setName("Aprender programação orientada a objoto");
//	task.setDescription("Estudar classes,métodos e atributos");
//	task.setCompleted(false);
//	task.setNotes("Sem notas");
//	task.setDeadline(new Date());

//	taskDAO.save(task);

	}
}
