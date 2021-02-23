package Products;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Videos.Base;
// LEA-19-7218
		public class ProductAPI extends Base{
	
		@Test(priority=1)
		public void PostProduct() throws IOException, ParseException{
				ProductOperations.PostProduct();
		}

		@Test(priority=2, dependsOnMethods={"PostProduct"})	
		public void GetPostedProduct() throws IOException{
				ProductOperations.GetPostedProduct();
		}


		@Test(priority=3, dependsOnMethods={"PostProduct"})	
		public void DeleteProduct(){
				ProductOperations.DeleteProduct();
		}

		@Test(priority=4)	
		public void PostProductwithGreaterThanRequiredNameLength() throws IOException, ParseException{
				ProductOperations.PostProductwithGreaterThanRequiredLengthName();
		}
	
		@Test(priority=5)	
		public void PostProductwithSpecialCharacterInNme() throws IOException, ParseException{
				ProductOperations.PostProductwithSpecialCharacterNme();
		}
	
	
		@Test(priority=6)
	
		public void GetAllProducts() throws InterruptedException{
				ProductOperations.GetAllProducts();
		}
	
		@Test(priority=7)	
		public void GetProductByXID(){
				ProductOperations.GetProductByXID();
		}
		
		@Test(priority=8)	
		public void DeleteExistingProduct(){
				ProductOperations.DeleteProduct1();
		}
		@Test(priority=9)	
	
		public void GetDeletedProduct(){
			ProductOperations.GetDeletedProduct();
		}


	
		
		

		
/*
 
		@Test(priority=10)	
		public void GetAllProductsAfterDeletion(){
			//ProductOperations.GetAllProductsAfterDeletion();
		}
	
		@Test(priority=11)	
		public void InactiveProduct() throws IOException{
			ProductOperations.InactiveProduct();
		}
	
	
		@Test(priority=12)	
		public void DeleteInactiveProduct() throws IOException{
			ProductOperations.DeleteInactiveProduct();
	}



@Test(priority=9)	

public void GetAllProductsAfterPosting() throws IOException{
	ProductOperations.GetAllProductsAfterPosting();
}

*/

}
