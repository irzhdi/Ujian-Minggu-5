package com.juaracoding.ujianm5.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.ujianm5.drivers.DriverSingleton;

public class Hotels {
private WebDriver driver;
	
	public Hotels() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#fadein > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li")
	List<WebElement> searchHotels2;
	
	@FindBy(css = "#fadein > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement inputCityName;
	
	@FindBy(css = "#select2-hotels_city-results > li > i")
	WebElement clickSingapore;
	
	@FindBy(id = "checkin")
	WebElement clickCheckin;
	
	@FindBy(css = "#fadein > div:nth-child(20) > div.datepicker-days > table > tbody > tr:nth-child(5) > td.day.active")
	WebElement clickDCheckin;
	
	@FindBy(id = "checkout")
	WebElement clickCheckout;
	
//	@FindBy(css = "#fadein > div:nth-child(21) > div.datepicker-days > table > tbody > tr:nth-child(5) > td.day.active")
//	WebElement clickDCheckout;
	
	@FindBy(css = "#select2-hotels_city-container")
	WebElement clickCityName;
	
	@FindBy(css = "#submit > span.ladda-label")
	WebElement btnSearch;
	
	@FindBy(className = "sec__title_list")
	WebElement txtSingapore;
	
	
	public void submitSearchHotels(String cityName) {
		searchHotels2.get(1).click();
		clickCityName.click();
		inputCityName.sendKeys(cityName);
		clickSingapore.click();
		clickCheckin.click();
		clickDCheckin.click();
		clickCheckout.click();
//		clickDCheckout.click();
		btnSearch.click();
	}
	
	public String getTxtSingapore() {
		return txtSingapore.getText();
	}
	
	
	public static void tunggu() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
