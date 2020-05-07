package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LinkedHashMap {

	public LinkedHashMap() {
		super();

	}

	public Map <Integer, Projects> convertProject(List<Projects> list){
	Map<Integer, Projects> map = list.stream().collect(Collectors.groupingBy(EmployeeList:: getNames, Collectors.mapping(EmployeeList :: getScore, downstream) ));
	return map;
	}
	
	public void entrySet(Map<Integer, String>map) {
		for(Map.Entry<Integer, String>entry: map.entrySet());
			
		
	}
	
	HashMap<Integer,List<Projects>> employeeList = new HashMap<Integer,List<Projects>>();
	
	public synchronized void addToList(Integer id, Projects myProject) {
		List<Projects>listOfProjects = employeeList.get(id);
		
		//if list does not exist create it
		if(listOfProjects == null) {
			listOfProjects = new ArrayList<Projects>();
			listOfProjects.add(myProject);
			employeeList.put(id,listOfProjects);
		}else {
			//add if Project is not already on list
			if(!listOfProjects.contains(myProject))listOfProjects.add(myProject);
		}
		
		//print the key and value
			map.forEach((id,myProject) -> System.out.println(id + " =" + myProject));
	}
	
}
