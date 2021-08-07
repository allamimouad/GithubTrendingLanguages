package dto;

import java.util.ArrayList;
import java.util.List;

import pojo.Repository;

public class Language {
	
	private String name;
	private int reposNumber;
	private List<Repository> repositoriesList;
	
	
	
	public Language(String name, Repository repository) {
		super();
		this.name = name;
		this.reposNumber = 1;
		this.repositoriesList = new ArrayList<>();
		repositoriesList.add(repository);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReposNumber() {
		return reposNumber;
	}
	public void setReposNumber(int reposNumber) {
		this.reposNumber = reposNumber;
	}
	public List<Repository> getRepositoriesList() {
		return repositoriesList;
	}
	public void setRepositoriesList(List<Repository> repositoriesList) {
		this.repositoriesList = repositoriesList;
	}
	
}
