package interfaces;

import org.openqa.selenium.By;

public class I_CreateAccountPages {
		
	
	public static By btn_WelcomePage1 = By.xpath("//a[@href='#page2']/button[contains(@class,'welcome')]");
	public static By btn_WelcomePage2 = By.xpath("//a[@href='#page3']/button[contains(@class,'welcome')]");
	public static By btn_WelcomePage3 = By.xpath("//a[@href='/user/question']/button[contains(@class,'welcome')]");
	
	public static By btn_Submit = By.xpath("//button[contains(@class,'btn-submit')]");
	public static By btn_SubmitAnswer = By.xpath("//button[contains(@class,'btn-submit')]");
	
	public static By txt_answer = By.xpath("//textarea[contains(@class,'form-control')]");
	
	
	//After Confirm Mail/Profile1
	public static By btn_SubmitFirstProfile = By.xpath("//button[contains(@class,'red white')]");
	public static By sel_Smoking = By.xpath("//select[@class='select-custom'][@tabindex='1']");
	public static By sel_Religion = By.xpath("//select[@class='select-custom'][@tabindex='2']");
	public static By txt_Height = By.xpath("//input[contains(@class,'input-custom')][@tabindex='3']");
	public static By sel_DescribleSelf = By.xpath("//select[@class='select-custom'][@tabindex='4']");
	public static By sel_MaritalStatus = By.xpath("//select[@class='select-custom'][@tabindex='5']");
	public static By sel_HowImportant = By.xpath("//select[@class='select-custom'][@tabindex='6']");
	public static By sel_JudgeSelf = By.xpath("//select[@class='select-custom'][@tabindex='7']");
	public static By sel_EstimateAppearance = By.xpath("//select[@class='select-custom'][@tabindex='8']");
	public static By sel_HowManyChildfren = By.xpath("//select[@class='select-custom'][@tabindex='9']");
	public static By sel_ChildrenHoldHouse = By.xpath("//select[@class='select-custom'][@tabindex='10']");
	public static By sel_LikeChildrenPartner = By.xpath("//select[@class='select-custom'][@tabindex='11']");
	
	
	//After Confirm Mail/Profile 2
	public static By txt_JobTitle = By.xpath("//input[contains(@class,'testJobTitle')]");
	public static By select_HighestDegree = By.xpath("//select[contains(@class,'testDegree')]");
	public static By select_ProfessionalGuild = By.xpath("//select[contains(@class,'testOccupation')]");
	public static By select_Country = By.xpath("//select[contains(@class,'testCountry')]");
	public static By txt_FirstName = By.xpath("//input[contains(@class,'testFirstName')]");
	public static By txt_LastName = By.xpath("//input[contains(@class,'testLastName')]");
	public static By select_Day = By.xpath("//select[contains(@class,'testDay')]");
	public static By select_Month = By.xpath("//select[contains(@class,'testMonth')]");
	public static By select_Year = By.xpath("//select[contains(@class,'testYear')]");
	public static By select_Income = By.xpath("//select[contains(@class,'testIncome')]");
	public static By txt_PostCode = By.xpath("//input[contains(@class,'testPostal')]");
	public static By txt_Location = By.xpath("//input[contains(@class,'testReferral')]");
	public static By chkbox_confirm = By.xpath("//input[@id='newsLetterActivate']");
	public static By btn_submitSecondProfile = By.xpath("//button[contains(@class,'btn btn-red')]");
	
	//Popup Premium Zero
	
	public static By lik_PremiumCancel = By.xpath("//a[contains(text(),'Premium nicht nutzen')]");
	
	//Upload Profile Picture Page
	
	public static By lnk_UploadLater = By.xpath("//a[@title='Fotos später hochladen']");
	public static By lnk_StillUploadLater = By.xpath("//a[@title='Trotzdem später hochladen']");
	
	//Invite Friend Page
	//First Question Page
	
	public static By sel_Question1 = By.xpath("//select[contains(@class,'custom margin')]");
	public static By txt_Answer1 = By.id("ans-01");
	public static By sel_Question2 = By.xpath("//div[@class='second-question-group']/select[@class='select-custom']");
	public static By txt_Answer2 = By.id("ans-02");
	public static By txt_ProfileWelcome = By.id("profile-welcome");
	public static By btn_SubmitFinish = By.id("setup-submit");
	
}


