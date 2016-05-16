import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Read_Input {

	public static LinkedList<Patient> getPatientsList(String[] args) {
		
		// Read in Patient file
		ArrayList<Patient> patients_list = new ArrayList<Patient>();
		
		try {
			
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
		
		/*for(int i=0; i< patients_list.size(); i++) {
			Patient p = patients_list.get(i);
			System.out.println(p.id + ", " + p.name + ", " + p.dob + ", " + p.gender);
		}*/
		
		
		
		// Read in Movement file
		ArrayList<Ward> wards_list = new ArrayList<Ward>();
		
		try {// Read in file
			
		File file = new File("wards.csv");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				String[] x = line.split(",");
				
				int id = Integer.parseInt(x[0]);
				String name = x[1];
				int capacity = Integer.parseInt(x[2]);
				
				Ward w = new Ward(id, name, capacity);
				wards_list.add(w);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*for(int i=0; i< wards_list.size(); i++) {
			Ward w = wards_list.get(i);
			System.out.println(w.id + ", " + w.name + ", " + w.capacity);
		}*/
		
		
		// Read in Movement file
		ArrayList<Movement> movements_list = new ArrayList<Movement>();
			
		try {// Read in file
			
			File file = new File("movements.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
					
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				String[] x = line.split(",");
						
				int event_index = Integer.parseInt(x[0]);
				int id = Integer.parseInt(x[1]);
				
				String from_ward = x[2];
				String to_ward = x[3];
				
				String[] y = x[4].split("-");
				@SuppressWarnings("deprecation")
				Date date = new Date(Integer.parseInt(y[2]), Integer.parseInt(y[1]), Integer.parseInt(y[0]));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				String strDate = sdf.format(date);
				
				Movement m = new Movement(event_index, id, from_ward, to_ward, strDate);
				movements_list.add(m);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*for(int i=0; i< movements_list.size(); i++) {
			Movement m = moevements_list.get(i);
			System.out.println();
		}*/		
		
		
	}

}
