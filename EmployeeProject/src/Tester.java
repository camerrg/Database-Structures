import java.util.Scanner;

import controller.ProjectHelper;
import model.Projects;

public class Tester {

	
		static Scanner in = new Scanner(System.in);
		static ProjectHelper lih = new ProjectHelper();

		private static void addProject() {
			
			
			System.out.print("Enter a Project Name: ");
			String projectName = in.nextLine();
			System.out.print("Enter an score: ");
			int score = in.nextInt();
			Projects toAdd = new Projects(projectName,score);
			lih.insertProject(toAdd);

		}
	

}
