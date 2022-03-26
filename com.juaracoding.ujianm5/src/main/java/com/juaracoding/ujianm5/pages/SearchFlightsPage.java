package com.juaracoding.ujianm5.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujianm5.drivers.DriverSingleton;

public class SearchFlightsPage {
	
	private WebDriver driver;
	
	public SearchFlightsPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#fadein > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li")
	List<WebElement> searchFlights;
	
	@FindBy(css = "#new-york > div > div:nth-child(5) > a > div > div > div.col-7 > h6")
	WebElement txtFlights;
	
	public void goToMenuSearchFlights() {
		searchFlights.get(2).click();
	}
	public String getTxtFlights() {
		return txtFlights.getText();
	}
}
