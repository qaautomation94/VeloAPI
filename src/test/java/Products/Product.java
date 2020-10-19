package Products;

public class Product {

    private String ExternalProductId;
    private String Name;
    private String Description;
    private String Summary;
    
	public Product(String externalProductId, String name, String description, String summary) {
	//	super();
		ExternalProductId = externalProductId;
		Name = name;
		Description = description;
		Summary = summary;
	}

	public String getExternalProductId() {
		return ExternalProductId;
	}

	public void setExternalProductId(String externalProductId) {
		ExternalProductId = externalProductId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
	}

	@Override
	public String toString() {
		return "Product [ExternalProductId=" + ExternalProductId + ", Name=" + Name + ", Description=" + Description
				+ ", Summary=" + Summary + "]";
	}

}
