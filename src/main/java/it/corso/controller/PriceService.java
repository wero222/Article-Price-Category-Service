package it.corso.controller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "priceservice", url = "localhost:8052")
public interface PriceService
{
	@GetMapping("/api/price/get/{code}")
	double getArticlePrice(@PathVariable("code") String code);
}