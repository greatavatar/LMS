package tests.sandbox;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import functions.*;
import interfaces.I_CreateAccountPages;
import interfaces.I_HomePage;
import variables.ConstantLib;
import variables.ConstantLib.Constants;
import variables.ConstantLib.TestGroup.AppFunction;
import variables.ConstantLib.TestGroup.Owner;
import variables.ConstantLib.TestGroup.Priority;
import variables.ConstantLib.TestGroup.TestSuite;
import verificationFunctions.F_AccountVerification;
import verificationFunctions.F_PartnerVerification;
import verificationFunctions.generalVerification;

//import io.qameta.allure.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONObject;
import variables.CommandLine;



//@Listeners(functions.customTestListenerAdapter.class)
public class test2 extends tests.DefaultAnnotations
{
	
	
	//@Test(groups = { Priority.Critical, TestSuite.Test, AppFunction.Account, Owner.xxxxxxxNguyen },invocationCount=1)
	@Test(groups = { Priority.Critical1, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	//@Severity(SeverityLevel.CRITICAL)
    //@Description("Test Description: Login test with empty username and empty password.")
    //@Story("Empty username and password login test")

	public void TC0022_Test() 
	{
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_UserId());
		ArrayList<User> ArrayUser = new ArrayList<User>();
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_UserId());
		F_Account.DS_GetValuesOfUsers("select a.id,a.dob,b.gender, b.gender_search,b.income_from,b.income_to,b.country from fos_user a inner join user_profile b on a.id = b.user_id where a.complete_profile_2_at is not null and a.id in (26,2838)", ArrayUser);
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_UserId());
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_UserId());
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_IncomeFrom());
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_Age());
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_Gender());
		System.out.println("--------------------" + ArrayUser.get(0).getSQL_GenderSearch());
		System.out.println("--------------------element 2----------");
		System.out.println("--------------------" + ArrayUser.get(1).getSQL_UserId());
		System.out.println("--------------------" + ArrayUser.get(1).getSQL_IncomeFrom());
		System.out.println("--------------------" + ArrayUser.get(1).getSQL_Age());
		System.out.println("--------------------" + ArrayUser.get(1).getSQL_Gender());
		System.out.println("--------------------" + ArrayUser.get(1).getSQL_GenderSearch());
		
		String query = "{\"from\":0,\"size\":10000,\"query\":{\"terms\":{\"user_id\":[" + 2838 +  "," +  26  + "]}}}";
		F_Account.ES_GetValuesOfUsers(query, ArrayUser);
		System.out.println("--------------------" + ArrayUser.get(0).getES_UserId());
		System.out.println("--------------------" + ArrayUser.get(0).getES_IncomeFrom());
		System.out.println("--------------------" + ArrayUser.get(0).getES_Age());
		System.out.println("--------------------" + ArrayUser.get(0).getES_Gender());
		System.out.println("--------------------" + ArrayUser.get(0).getES_GenderSearch());
		System.out.println("--------------------element 2----------");
		System.out.println("--------------------" + ArrayUser.get(1).getES_UserId());
		System.out.println("--------------------" + ArrayUser.get(1).getES_IncomeFrom());
		System.out.println("--------------------" + ArrayUser.get(1).getES_Age());
		System.out.println("--------------------" + ArrayUser.get(1).getES_Gender());
		System.out.println("--------------------" + ArrayUser.get(1).getES_GenderSearch());
		
		F_AccountVerification.ES_DS_Verify_Data_Synchronize_Between_ES_MYSQL_For_All_Users(Result);
		
		F_Account.DS_GetRightProductIDsForAUser("774");
		String Data = "81/1729,1730,1731:13686/547,548,549:42613/1141,1142,1143:47510/103,104,105:47660/1144,1145,1146:51808/2077,2078,2079:54430/502,503,504:54967/577,578,579:57537/2920,2921,2922:57722/2026,2027,2028:57756/556,557,558:57972/2089,2090,2091:60648/1156,1157,1158:60763/703,704,705:60782/703,704,705:60813/604,605,606:60847/2032,2033,2034:60899/679,680,681:61048/2146,2147,2148:61050/2761,2762,2763:61064/574,575,576:61081/1669,1670,1671:61116/1711,1712,1713:61132/580,581,582:61201/493,494,495:6382/622,623,624:10743/82,83,84:10876/577,578,579:11027/2089,2090,2091:43668/2203,2204,2205:8415/577,578,579:8417/2056,2057,2058:8926/547,548,549:13195/778,779,780:17634/2089,2090,2091:34364/2056,2057,2058:34939/577,578,579:42811/2026,2027,2028:47314/685,686,687:54450/589,590,591:57508/634,635,636:57710/607,608,609:57712/592,593,594:57803/2119,2120,2121:58035/556,557,558:60595/2074,2075,2076:60643/571,572,573:60936/1141,1142,1143:61052/697,698,699:61079/514,515,516:61111/2056,2057,2058:61143/619,620,621:2544/604,605,606:6288/607,608,609:7088/2053,2054,2055:18695/1642,1643,1644:19156/1333,1334,1335:35841/625,626,627:46830/907,908,909:50835/667,668,669:54241/553,554,555:54366/2026,2027,2028:56781/607,608,609:57349/2320,2321,2322:57369/97,98,99:59757/2146,2147,2148:59764/2473,2474,2475:59966/610,611,612:59973/2146,2147,2148:60100/562,563,564:60132/607,608,609:60300/607,608,609:62960/2194,2195,2196:29041/568,569,570:29332/571,572,573:33183/2227,2228,2229:49513/676,677,678:49672/508,509,510:53491/652,653,654:53541/652,653,654:56074/640,641,642:56417/1651,1652,1653:56456/1699,1700,1701:58982/610,611,612:59289/571,572,573:59657/601,602,603:59659/703,704,705:62022/2029,2030,2031:62213/508,509,510:62288/118,119,120:62415/1141,1142,1143:62506/601,602,603:54048/2074,2075,2076:57221/550,551,552:57255/625,626,627:59760/133,134,135:59928/3040,3041,3042:59963/2020,2021,2022:60031/547,548,549:60062/91,92,93:60178/601,602,603:60248/610,611,612:60331/145,146,147:62818/511,512,513:5379/595,596,597:5829/655,656,657:19399/1669,1670,1671:20220/1204,1205,1206:32519/526,527,528:44806/1717,1718,1719:58524/1672,1673,1674:58793/1729,1730,1731:61349/2098,2099,2100:61350/28,29,30:61366/2275,2276,2277:61401/1192,1193,1194:61450/1732,1733,1734:61548/1624,1625,1626:61683/3025,3026,3027:61950/532,533,534:61985/1687,1688,1689:62000/1624,1625,1626:774/2269,2270,2271:4802/97,98,99:8946/604,605,606:17688/1660,1661,1662:17971/1684,1685,1686:42924/577,578,579:43408/2056,2057,2058:47638/2194,2195,2196:47972/592,593,594:48090/571,572,573:51847/1144,1145,1146:54538/2077,2078,2079:60691/1717,1718,1719:60906/496,497,498:61008/688,689,690:61042/2056,2057,2058:61089/271,272,273:61122/634,635,636:61226/508,509,510:2227/607,608,609:10550/2059,2060,2061:10851/1141,1142,1143:14063/502,503,504:18910/574,575,576:27181/2056,2057,2058:31910/589,590,591:35604/2026,2027,2028:36039/2134,2135,2136:46753/619,620,621:54187/2086,2087,2088:56894/562,563,564:57215/58,59,60:59804/2086,2087,2088:59921/811,812,813:60356/640,641,642:60357/2029,2030,2031:62780/1141,1142,1143:62797/1735,1736,1737:62828/508,509,510:62913/577,578,579:7293/685,686,687:7459/1084,1085,1086:12609/1687,1688,1689:20447/589,590,591:25393/1717,1718,1719:29956/574,575,576:33799/604,605,606:38061/2026,2027,2028:53237/532,533,534:56394/493,494,495:56545/523,524,525:56561/2137,2138,2139:59317/1156,1157,1158:59369/19,20,21:59503/544,545,546:59537/595,596,597:59621/1717,1718,1719:62261/592,593,594:62361/694,695,696:62596/577,578,579:62647/2059,2060,2061:62733/529,530,531:62740/595,596,597:62751/2260,2261,2262:1474/2059,2060,2061:1615/688,689,690:5266/562,563,564:5525/1144,1145,1146:5527/520,521,522:5970/685,686,687:10282/1654,1655,1656:36318/514,515,516:40682/2227,2228,2229:44699/2023,2024,2025:45224/10,11,12:52087/619,620,621:52135/493,494,495:52144/655,656,657:52228/592,593,594:55656/607,608,609:58453/2272,2273,2274:58864/2206,2207,2208:58937/2266,2267,2268:58948/2194,2195,2196:61336/493,494,495:61688/790,791,792:61797/619,620,621:61813/2059,2060,2061:61999/640,641,642:3373/1156,1157,1158:7600/2089,2090,2091:16127/2227,2228,2229:21358/1141,1142,1143:49970/574,575,576:53278/2245,2246,2247:55903/514,515,516:56585/607,608,609:58991/751,752,753:59279/493,494,495:59546/493,494,495:59645/619,620,621:62069/556,557,558:62084/2074,2075,2076:62153/499,500,501:62317/1714,1715,1716:62551/2083,2084,2085:62568/2056,2057,2058:62585/496,497,498:62670/118,119,120:62685/493,494,495:62687/2086,2087,2088:8334/541,542,543:8600/544,545,546:12844/1717,1718,1719:13698/124,125,126:30051/1669,1670,1671:38489/2029,2030,2031:38793/499,500,501:42612/1657,1658,1659:47549/499,500,501:54642/520,521,522:54919/2194,2195,2196:58138/148,149,150:60642/1729,1730,1731:60644/2026,2027,2028:60712/559,560,561:60810/2134,2135,2136:60828/508,509,510:60862/2119,2120,2121:60944/730,731,732:60996/607,608,609:61069/625,626,627:61137/895,896,897:61255/2029,2030,2031:10783/0,0,0:14125/2164,2165,2166:26959/634,635,636:31971/2056,2057,2058:36251/691,692,693:46888/700,701,702:51002/1423,1424,1425:53681/2206,2207,2208:56784/589,590,591:59815/691,692,693:59890/2920,2921,2922:59915/1144,1145,1146:59924/2062,2063,2064:59985/2026,2027,2028:60124/1216,1217,1218:60192/604,605,606:60192/604,605,606:60308/580,581,582:60333/577,578,579:60374/577,578,579:60383/508,509,510:60442/496,497,498:62857/2026,2027,2028:62868/2233,2234,2235:62941/604,605,606:62943/607,608,609:62966/589,590,591:12101/1144,1145,1146:16806/2119,2120,2121:20627/1657,1658,1659:25389/2104,2105,2106:37423/1669,1670,1671:45579/1471,1472,1473:46145/499,500,501:53149/610,611,612:59165/2059,2060,2061:59281/2119,2120,2121:59290/2089,2090,2091:59542/529,530,531:59583/2026,2027,2028:59608/1654,1655,1656:59622/1705,1706,1707:62021/2089,2090,2091:62048/2104,2105,2106:62116/2071,2072,2073:62148/2236,2237,2238:62291/2089,2090,2091:62600/514,515,516:62757/673,674,675:5619/607,608,609:15404/1684,1685,1686:24301/2071,2072,2073:27920/505,506,507:44648/2245,2246,2247:52120/2026,2027,2028:52227/493,494,495:52247/2131,2132,2133:58193/2074,2075,2076:58313/1756,1757,1758:61380/2086,2087,2088:61430/559,560,561:61639/2056,2057,2058:61698/652,653,654:61739/514,515,516:61746/2026,2027,2028:61764/685,686,687:61780/604,605,606:62728/493,494,495:9516/550,551,552:9632/622,623,624:10185/1141,1142,1143:19257/1672,1673,1674:19477/1342,1343,1344:24056/1144,1145,1146:24272/607,608,609:27831/562,563,564:44393/1714,1715,1716:48657/2062,2063,2064:52499/2089,2090,2091:58215/499,500,501:58215/499,500,501:58465/547,548,549:58751/145,146,147:61289/610,611,612:61406/532,533,534:61576/1261,1262,1263:61576/1261,1262,1263:61624/679,680,681:61660/649,650,651:61692/679,680,681:61908/2056,2057,2058:61976/2134,2135,2136:61839/2203,2204,2205:61839/2203,2204,2205:61846/2026,2027,2028:61882/619,620,621:61921/2086,2087,2088:61964/1774,1775,1776";
	
		Assert.assertTrue(Result.Result, Result.Message);
	
	}
	
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TCTest2_1_Test() 
	{
		
		//F_PartnerVerification.API_Verify_Matching_List_For_A_Random_User_Has_Data(Result);
		//F_Account.DS_GetValuesInAColumn("select * from fos_user where id = 101", "id");
		//F_PartnerVerification.API_Verify_Matching_List_For_All_Users_Has_Data(Result);
		
     
		Assert.assertTrue(Result.Result, Result.Message);
	
	}
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TCTest2_2_Test() 
	{
		/*for(int i=0;i<30;i++)
		{
			F_Account.LoginSpamAccount("testdung", "@discard.email");
		}*/
		//Result.Result = false;
		//Result.Message = "test";
		
		if(generalFunctions.getRandomInt(0, 2) == 0)
		{
			Result.Result = false;
			Result.Message = "---------------------------------FAIL ROIIIIIIIIIIII--------";
		}
		
		Assert.assertTrue(Result.Result, Result.Message);
	
	}
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TCTest2_3_Test() 
	{
		/*for(int i=0;i<30;i++)
		{
			F_Account.LoginSpamAccount("testdung", "@discard.email");
		}*/
		//Result.Result = false;
		//Result.Message = "test";
		
		if(generalFunctions.getRandomInt(0, 2) == 0)
		{
			Result.Result = false;
			Result.Message = "---------------------------------FAIL ROIIIIIIIIIIII--------";
		}
		
		Assert.assertTrue(Result.Result, Result.Message);
	
	}
	@Test(groups = { Priority.Critical, TestSuite.Regression, AppFunction.Account, Owner.xxxxxxxNguyen })
	public void TCTest2_4_Test() 
	{
		/*for(int i=0;i<30;i++)
		{
			F_Account.LoginSpamAccount("testdung", "@discard.email");
		}*/
		//Result.Result = false;
		//Result.Message = "test";
		
		if(generalFunctions.getRandomInt(0, 2) == 0)
		{
			Result.Result = false;
			Result.Message = "---------------------------------FAIL ROIIIIIIIIIIII--------";
		}
		
		Assert.assertTrue(Result.Result, Result.Message);
	
	}
	
}




//allure serve allure-results/
