import com.dao.medicineDao;

import java.util.List;

import com.bean.Medicine;
public class medicineTest {
   public static void main(String[] args) {
        Medicine medicine = new Medicine();
        medicine.setName("丁香");
        medicine.setMetric("g");
        medicine.setPrice(1.17);
        medicine.setLeftnumber(99999);
        medicine.setShort_desc("dx");
        medicineDao.updateMedecine(medicine);
   } 
}
