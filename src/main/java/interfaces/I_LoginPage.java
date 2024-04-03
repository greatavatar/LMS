package interfaces;

import org.openqa.selenium.By;

public class I_LoginPage {
	public static By lnk_ForgotPassword = By.xpath("//a[@class='login__text-link'][@href='/forgot-password']");
	public static By btn_Login = By.id("login-submit");
	public static By btn_Facebook = By.id("facebook-login-btn");
	public static By btn_Google = By.id("google-login-btn");
	
	public static By txt_Email = By.id("email");
	public static By txt_Password = By. id("password");
	
	public static By txt_FaceboolEmail = By.id("email");
	public static By txt_FaceboolPassword = By.id("pass");
	public static By btn_FaceboolLogin = By.id("loginbutton");
	
	public static By txt_GoogleEmail = By.id("identifierId");
	public static By	 btn_GoogleNext = By.xpath("//span[contains(text(),'Next')]");  
	public static By txt_GooglePassword = By.xpath("//input[@name='password']");
	
	
}


