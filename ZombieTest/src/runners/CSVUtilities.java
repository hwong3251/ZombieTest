package runners;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CSVUtilities {
	private static ArrayList<String> CSVData = new ArrayList<String>();
	private int numColumn;
	public CSVUtilities(File csv) throws IOException {
		FileReader csv2 = new FileReader(csv);
		
		try (BufferedReader br = new BufferedReader(csv2)) {
			String line = br.readLine();
			while (line != null) {
				CSVData.add(line);
				line = br.readLine();
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		this.numColumn = getColumnHeaders().size();
	}
	public List<String> getColumnHeaders()
	{
		return Arrays.asList(CSVData.get(0).split(","));
	}
	public static List<String> getDataString(int column)
	{
		List<String> data = new ArrayList<String>();
		for (int i = 1; i < CSVData.size(); i++) 
		{
			String[] row = CSVData.get(i).split(",");
			data.add(row[column]);
		}
		return data;
	}
	public static List<Integer> getDataInt(int column) {
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int x = 1; x < CSVData.size(); x++)
		{
			String[] temp = CSVData.get(x).split(",");
			data.add(Integer.parseInt(temp[column]));
		}
		return data;
	}
	public static List<Double> getDataDouble(int column) 
	{
		ArrayList<Double> data = new ArrayList<Double>();
		for (int x = 1; x < CSVData.size(); x++) 
		{
			String[] temp = CSVData.get(x).split(",");
			data.add(Double.parseDouble(temp[column]));
		}
		return data;
	}

}