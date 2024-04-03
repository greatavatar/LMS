package variables;

import org.json.JSONException;
import org.json.JSONObject;

public class Product {

	 private String ProductID1;
	 private String ProductID1_PriceGross ;
	 private String ProductID2;
	 private String ProductID2_PriceGross ;
	 private String ProductID3;
	 private String ProductID3_PriceGross ;
	 private String ProductRenewalID1;
	 private String ProductRenewalID1_PriceGross ;
	 private String ProductRenewalID2;
	 private String ProductRenewalID2_PriceGross ;
	 private String ProductRenewalID3;
	 private String ProductRenewalID3_PriceGross ;
	 private String UserID = "";
	
	  
	  public String getUserID()
	  {
		  return this.UserID;
	  }
	  public void setUserID ( String pUserID ) 
	  {
			this.UserID = pUserID;
	  }
	  public String getProductID1()
	  {
		  return this.ProductID1;
	  }
	  public void setProductID1 ( String pProductID1 ) 
	  {
			this.ProductID1 = pProductID1;
	  }
	  public String getProductID2()
	  {
		  return this.ProductID2;
	  }
	  public void setProductID2 ( String pProductID2 ) 
	  {
			this.ProductID2 = pProductID2;
	  }
	  public String getProductID3()
	  {
		  return this.ProductID3;
	  }
	  public void setProductID3 ( String pProductID3 ) 
	  {
			this.ProductID3 = pProductID3;
	  }
	  public String getProductRenewalID1()
	  {
		  return this.ProductRenewalID1;
	  }
	  public void setProductRenewalID1 ( String pProductRenewalID1 ) 
	  {
			this.ProductRenewalID1 = pProductRenewalID1;
	  }
	  public String getProductRenewalID2()
	  {
		  return this.ProductRenewalID2;
	  }
	  public void setProductRenewalID2 ( String pProductRenewalID2 ) 
	  {
			this.ProductRenewalID2 = pProductRenewalID2;
	  }
	  public String getProductRenewalID3()
	  {
		  return this.ProductRenewalID3;
	  }
	  public void setProductRenewalID3 ( String pProductRenewalID3 ) 
	  {
			this.ProductRenewalID3 = pProductRenewalID3;
	  }
	  public String getProductID1_PriceGross()
	  {
		  return this.ProductID1_PriceGross;
	  }
	  public void setProductID1_PriceGross ( String pProductID1_PriceGross ) 
	  {
			this.ProductID1_PriceGross = pProductID1_PriceGross;
	  }
	  public String getProductID2_PriceGross()
	  {
		  return this.ProductID2_PriceGross;
	  }
	  public void setProductID2_PriceGross ( String pProductID2_PriceGross ) 
	  {
			this.ProductID2_PriceGross = pProductID2_PriceGross;
	  }
	  public String getProductID3_PriceGross()
	  {
		  return this.ProductID3_PriceGross;
	  }
	  public void setProductID3_PriceGross ( String pProductID3_PriceGross ) 
	  {
			this.ProductID3_PriceGross = pProductID3_PriceGross;
	  }
	  public String getProductRenewalID1_PriceGross()
	  {
		  return this.ProductRenewalID1_PriceGross;
	  }
	  public void setProductRenewalID1_PriceGross ( String pProductRenewalID1_PriceGross ) 
	  {
			this.ProductRenewalID1_PriceGross = pProductRenewalID1_PriceGross;
	  }
	  public String getProductRenewalID2_PriceGross()
	  {
		  return this.ProductRenewalID2_PriceGross;
	  }
	  public void setProductRenewalID2_PriceGross ( String pProductRenewalID2_PriceGross ) 
	  {
			this.ProductRenewalID2_PriceGross = pProductRenewalID2_PriceGross;
	  }
	  public String getProductRenewalID3_PriceGross()
	  {
		  return this.ProductRenewalID3_PriceGross;
	  }
	  public void setProductRenewalID3_PriceGross ( String pProductRenewalID3_PriceGross ) 
	  {
			this.ProductRenewalID3_PriceGross = pProductRenewalID3_PriceGross;
	  }
	  
}

