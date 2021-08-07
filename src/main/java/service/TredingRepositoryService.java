package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import consumer.api.github.TrendingRepositoriesConsumer;
import dto.Language;
import pojo.Repository;

public class TredingRepositoryService {
	
	
	private TrendingRepositoriesConsumer trendingRepositoriesConsumer;
	
	public TredingRepositoryService() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		Date date = calendar.getTime();
		
		this.trendingRepositoriesConsumer = new TrendingRepositoriesConsumer(date);
		
	}
	
	public List<Repository> get100TrendingRepositories() throws Exception {
		
		return trendingRepositoriesConsumer.getTrendingRepositories()
				.stream()
				.filter(repository -> repository.getLanguage() != null)
				.filter(repository -> !repository.getLanguage().equals("null"))
				.collect(Collectors.toList());
	}
	
	public List<Language> getLanguagesOf100TrendingRepository() throws Exception{
		
		List<Language> languagesList = new ArrayList<>();
		
		List<Repository> listRepositories = get100TrendingRepositories();
		
		listRepositories.forEach(repository -> {
			
			
			
			if(containsName(languagesList,repository.getLanguage())) {
				Language language1 = languagesList.stream()
													.filter(language-> language.getName().equals(repository.getLanguage()))
													.findFirst()
													.orElse(null);
				
				language1.setReposNumber(language1.getReposNumber() +1);
				language1.getRepositoriesList().add(repository);
			}
			else {
				languagesList.add(new Language(repository.getLanguage(),repository));
			}
		});
		
		return languagesList;
		
	}

	public boolean containsName(final List<Language> list, final String name){
	    return list.stream().map(Language::getName).filter(name::equals).findFirst().isPresent();
	}

}
