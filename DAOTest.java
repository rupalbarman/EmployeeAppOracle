import java.sql.*;
import java.util.*;
import com.veltech.entity.Employee;
import com.veltech.dao.EmployeeDAO;

class DAOTest {

	public static void main(String[] args) {
		
		String connString= "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con= null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			EmployeeDAO edao= new EmployeeDAO(DriverManager.getConnection(connString, "system", "manager"));
			Employee e1= new Employee(111, "Zaha", 989898);
			edao.addEmployee(e1);

			Employee e2= edao.getEmployee(111);
			if(e2!= null) {
				System.out.println(e2.getName()+" "+ e2.getEmpId()+" "+ e2.getSalary());
			} else {
				System.out.println("111 does not exist");
			}

			if (edao.deleteEmployee(111)) {
				System.out.println("111 deleted");
			}

			ArrayList<Employee> elist= new ArrayList<Employee>();
			elist= edao.getAllEmployees();
			for(Employee e: elist) {
				System.out.println(e.getName()+" "+ e.getEmpId()+ " "+e.getSalary());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}