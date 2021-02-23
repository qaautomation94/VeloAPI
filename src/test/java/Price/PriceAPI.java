package Price;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Videos.Base;
// LEA-19-7218
		public class PriceAPI extends Base{
	
		@Test(priority=1)
		public void PostProduct() throws IOException, ParseException{
				PriceOperations.PostProduct();
		}

		@Test(priority=2, dependsOnMethods={"PostProduct"})	
		public void GetPostedProductPriceGrids() throws IOException{
				PriceOperations.GetAllPriceGrids();
		}
		
		@Test(priority=3, dependsOnMethods={"GetPostedProductPriceGrids"})	
		public void GetSinglePriceGrid() throws IOException{
				PriceOperations.GetSinglePriceGrid();
		}
		
		@Test(priority=4, dependsOnMethods={"GetSinglePriceGrid"})	
		public void DeleteSinglePriceGrid() throws IOException{
				PriceOperations.DeleteSinglePriceGrid();
		}
		
		/*
		@Test(priority=5)
		public void PostPriceGrid() throws IOException, ParseException{
				PriceOperations.PostPriceGrid();
		}
*/

}
