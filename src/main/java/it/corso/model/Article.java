package it.corso.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
public class Article
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cod_art")
	private String artCode;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "vat_rate", referencedColumnName = "rate")
	private VatRate vatRate;
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getArtCode()
	{
		return artCode;
	}
	public void setArtCode(String artCode)
	{
		this.artCode = artCode;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
	public VatRate getVatRate()
	{
		return vatRate;
	}
	public void setVatRate(VatRate vatRate)
	{
		this.vatRate = vatRate;
	}
}