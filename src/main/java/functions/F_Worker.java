package functions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import functions.generalFunctions;
import variables.TCResult;
import variables.ConstantLib.Constants;
import verificationFunctions.F_PartnerVerification;

public class F_Worker implements Runnable {

private String[] arrUserName;
private int To;
private int From;
private int TotalPerThread;
private TCResult mResult;
    
    public F_Worker (String[] pArrUserName,int pFrom, int pTo,int pTotalPerThread, TCResult pResult){
        this.arrUserName = pArrUserName;
        this.mResult=pResult;
        this.To = pTo;
        this.From = pFrom;
        this.TotalPerThread = pTotalPerThread;
    }
    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName()+"-------- Start. accessToken = "+accessToken);
        processCommand(arrUserName,From,To,TotalPerThread,mResult);
        //System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand(String[] pArrUserName,int pFrom, int pTo,int pTotalPerThread, TCResult pResult) {
        try {
        		F_PartnerVerification.API_Verify_Matching_List_For_List_User_Has_Data(pArrUserName,pFrom,pTo,pTotalPerThread,pResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        return this.mResult.GetMessage();
    }

}
