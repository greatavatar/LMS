package interfaces;

import org.openqa.selenium.By;

public class I_Payment {
		
	public static By lbl_Produktauswahl = By.xpath("//span[text()='Produktauswahl']");
	public static By img_lmsIcon = By.xpath("//img[@alt='home']");
	public static By btn_PremiumBASICBundle = By.xpath("//button[@class='btn btn-red btn-select-package hidden-xs'][contains(text(),'Weiter')]");
	public static By btn_PremiumSMARTBundle = By.xpath("//button[@class='btn btn-red btn-select-package btn-select-smart'][contains(text(),'Ich wähle Premium smart')]");
	public static By btn_PremiumCOMFORTBundle = By.xpath("//button[@class='btn btn-select-package btn-comfort hidden-xs'][contains(text(),'Weiter')]");
	
	public static By tab_Monthly = By.xpath("//label[@for='tabMonthlyPay']");
	public static By tab_Quarterly = By.xpath("//label[@for='tabQuarterlyPay']");
	public static By tab_SemiAnnual = By.xpath("//label[@for='tabSemiAnnualPay']");
	public static By tab_OneTime = By.xpath("//label[@for='tabOneTimePay']");
	
	public static By tab_DebitBanking = By.xpath("//div[@data-tab='debit']");
	public static By tab_CreditCard = By.xpath("//div[@data-tab='credit']");
	
	//------------------DEBIT BANKING payment
	public static By txt_AccountOwner = By.xpath("//input[@id='txtAcctOwner']");
	public static By txt_IBAN = By.xpath("//input[@id='txtIBAN']");
	public static By txt_BIC = By.xpath("//input[@id='txtBIC']");
	
	//SWICH TO IFRAME paymentIframe ---CREDIT CARD payment
	public static By txt_CardNumber = By.xpath("//input[@id='cardNumber']");
	public static By slt_ExpireMonth = By.xpath("//select[@id='expirationMonth']");
	public static By slt_ExpireYear = By.xpath("//select[@id='expirationYear']");
	public static By txt_VerificationNumber = By.xpath("//input[@id='verification']");
	public static By btn_DebitMonthlySubmit = By.xpath("//div[@data-panel-name='monthly']//button[contains(@class,'submit')]");
	public static By btn_DebitQuarterlySubmit = By.xpath("//div[@data-panel-name='quarterly']//button[contains(@class,'submit')]");
	public static By btn_DebitSemiAnnualSubmit = By.xpath("//div[@data-panel-name='semiannually']//button[contains(@class,'submit')]");
	public static By btn_DebitOneTimeSubmit = By.xpath("//div[@data-panel-name='one-time']//button[contains(@class,'submit')]");
	//public static By btn_CreditPaymentSubmit = By.xpath("//button[contains(@class,'submit')]/span[contains(text(),'Kaufen')]");
	
	//Complete billing phase
	public static By txt_FirstName = By.xpath("//input[@id='txtFirstName']");
	public static By txt_LastName = By.xpath("//input[@id='txtLastName']");
	public static By txt_AddrStreet = By.xpath("//input[@id='txtAddrStreet']");
	public static By txt_AddrHouseNo = By.xpath("//input[@id='txtAddrHouseNo']");
	public static By txt_AddrZip = By.xpath("//input[@id='txtAddrZip']");
	public static By txt_AddrCity = By.xpath("//input[@id='txtAddrCity']");
	public static By slt_Country = By.xpath("//select[@name='addressCountry']");
	public static By chb_Confirm = By.xpath("//input[@id='chkPaymentStatement']");
	public static By btn_Submit = By.xpath("//button[@id='btnSubmitBillingInfo']");
	
	
}


