import java.util.List;

import com.bean.Patient;
import com.dao.patientDao;

public class patientTest {
    public static void main(String[] args) {
        List<Patient> p =  patientDao.patientList(10000);
        System.out.println(p);
    }
}
