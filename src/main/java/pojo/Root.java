package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

	private List<Repository> items ;

	public List<Repository> getItems() {
		return items;
	}

	public void setItems(List<Repository> items) {
		this.items = items;
	}
	
}
