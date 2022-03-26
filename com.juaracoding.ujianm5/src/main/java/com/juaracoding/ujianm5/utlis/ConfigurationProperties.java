package com.juaracoding.ujianm5.utlis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@Value("${user}")
	private String userName;
	
	@Value("${txtWelcome}")
	private String txtWelcome;
	
	@Value("${txtTitleBookingPage}")
	private String txtTitleBookingPage;
	
	@Value("${txtTitleHotelsPage}")
	private String txtTitleHotelsPage;
	
	@Value("${txtFlights}")
	private String txtFlights;
	
	@Value("${cityName}")
	private String cityName;
	
	@Value("${txtSingapore}")
	private String txtSingapore;
	
//=====================================================
	
	public String getBrowser() {
		return browser;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getTxtWelcome() {
		return txtWelcome;
	}		
	public String getTxtTitleBookingPage() {
		return txtTitleBookingPage;
	}
	public String getTxtTitleHotelsPage() {
		return txtTitleHotelsPage;
	}	
	public String getTxtFlights() {
		return txtFlights;
	}		
	public String getCityName() {
		return cityName;
	}
	public String getTxtSingapore() {
		return txtSingapore;
	}		
}
