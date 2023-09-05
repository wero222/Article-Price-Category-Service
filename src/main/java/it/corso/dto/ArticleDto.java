package it.corso.dto;
import it.corso.model.Category;
import it.corso.model.VatRate;

public class ArticleDto
{
	private int id;
	private String artCode;
	private String description;
	private Category category;
	private VatRate vatRate;
	private double price = 0;
	
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
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
}