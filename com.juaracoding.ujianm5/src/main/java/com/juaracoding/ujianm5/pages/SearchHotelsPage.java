package com.juaracoding.ujianm5.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujianm5.drivers.DriverSingleton;

public class SearchHotelsPage {
	
private WebDriver driver;
	
	public SearchHotelsPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#fadein > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li")
	List<WebElement> searchHotels;
	
	public void goToMenuSearchHotels() {
		searchHotels.get(1).click();
	}
	public String getTxtTitleHotelsPage() {
		return driver.getTitle();
		
	}
}
