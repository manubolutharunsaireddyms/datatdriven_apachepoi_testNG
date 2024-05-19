package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path =".//testData/Data.xlsx";
		FileUtility fileu = new FileUtility(path);
		int rcount = fileu.getRowCount("sheet1");
		int ccount = fileu.getCellCount("sheet1", 1);
		String data [][] = new String[rcount][ccount];
		
		for(int i=1; i<=rcount;i++)
		{
			for (int j=0;j<ccount;j++)
			{
				data[i-1][j]= fileu.getCellData("sheet1", i, j);
			}
		}
		
		return data;	
	}
}
