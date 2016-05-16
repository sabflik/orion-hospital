import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class Read_Input {

	public static LinkedList<Patient> getPatientsList(String[] args) {
		
		LinkedList<Patient> patients_list = new LinkedList<Patient>();
		
		try {// Read in file
			
			File file = new File("patients.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				String[] x = line.split(",");
				int id = Integer.parseInt(x[0]);
				String name = x[1];
				String[] y = x[2].split("/");
				@SuppressWarnings("deprecation")
				Date dob = new Date(Integer.parseInt(y[2]), Integer.parseInt(y[1]), Integer.parseInt(y[0]));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				String strDate = sdf.format(dob);
				int gender = Integer.parseInt(x[3]);
				Patient p = new Patient(id, name, strDate, gender);
				patients_list.add(p);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
