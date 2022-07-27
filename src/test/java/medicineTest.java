import com.dao.medicineDao;

import java.util.List;

import com.bean.Medicine;
public class medicineTest {
   public static void main(String[] args) {
        List<Medicine> res = medicineDao.medicineList(10);
        for (Medicine m : res) {
            System.out.println(m.getName());
        }
        Medicine medicine = new Medicine();
        medicine.setName("枸杞");
        medicine.setMetric("g");
        medicine.setPrice(1.3);
        medicine.setLeftnumber(99999);
        medicine.setShort_desc("gq");
        medicineDao.addMedicine(medicine);
        res = medicineDao.medicineList(10);
        for (Medicine mm : res) {
            System.out.println(mm.getName());
        }
   } 
}
