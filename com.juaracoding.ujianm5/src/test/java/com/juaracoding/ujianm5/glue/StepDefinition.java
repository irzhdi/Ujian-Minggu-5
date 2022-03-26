package com.juaracoding.ujianm5.glue;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.ujianm5.config.AutomationFrameworkConfig;
import com.juaracoding.ujianm5.drivers.DriverSingleton;
import com.juaracoding.ujianm5.pages.BookingPage;
import com.juaracoding.ujianm5.pages.Hotels;
import com.juaracoding.ujianm5.pages.LoginPage;
import com.juaracoding.ujianm5.pages.SearchFlightsPage;
import com.juaracoding.ujianm5.pages.SearchHotelsPage;
import com.juaracoding.ujianm5.utlis.ConfigurationProperties;
import com.juaracoding.ujianm5.utlis.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private WebDriver driver;
	private LoginPage loginPage;
	private BookingPage bookingPage;
	private SearchHotelsPage searchHotelsPage;
	private SearchFlightsPage searchFlightsPage;
	private Hotels hotels;
	
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		bookingPage = new BookingPage();
		searchHotelsPage = new SearchHotelsPage();
		searchFlightsPage = new SearchFlightsPage();
		hotels = new Hotels();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}
	
	@When("Customer klik login button")
	public void customer_klik_login_button() {
		loginPage.submitLogin(configurationProperties.getEmail(), configurationProperties.getPassword());
	}
	
	@Then("Customer berhasil login")
	public void customer_berhasil_login() {
		//refresh
		driver.navigate().refresh();
		tunggu();
		assertEquals(configurationProperties.getTxtWelcome(), loginPage.getTxtWelcome());
	}
	
	@When ("Customer klik menu My Booking")
	public void customer_klik_menu_my_booking() {
		bookingPage.goToMenuMyBooking(); 
	}
	
	@Then ("Customer melihat page title")
	public void customer_melihat_page_title() {
	
		assertEquals(configurationProperties.getTxtTitleBookingPage(), bookingPage.getTxtTitleBookingPage());
	}
	@When ("Customer klik menu Hotels")
	public void Customer_klik_menu_hotels() {
		tunggu();
		searchHotelsPage.goToMenuSearchHotels(); 
	}
	
	@Then ("Customer melihat page title search hotels")
	public void Customer_melihat_page_title_search_hotels() {
		tunggu();
		assertEquals(configurationProperties.getTxtTitleHotelsPage(), searchHotelsPage.getTxtTitleHotelsPage());
	}
	


	@When ("Customer klik menu Flights")
	public void Customer_klik_menu_Flights() {
		searchFlightsPage.goToMenuSearchFlights();
		tunggu();
		
	}
	
	@Then ("Customer melihat page search flights")
	public void Customer_melihat_page_search_flights() {
		tunggu();
		assertEquals(configurationProperties.getTxtFlights(), searchFlightsPage.getTxtFlights());
	}
	
	@When ("Customer klik menu search hotels")
	public void Customer_klik_menu_search_hotels() {
		hotels.submitSearchHotels(configurationProperties.getCityName());
		
	}
	@Then ("Customer berhasil input search hotel")
	public void Customer_berhasil_input_search_hotel() {
		assertEquals(configurationProperties.getTxtSingapore(), hotels.getTxtSingapore());
	}

	
	
	public static void tunggu() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
