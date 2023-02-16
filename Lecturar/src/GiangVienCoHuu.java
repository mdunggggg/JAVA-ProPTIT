import static java.lang.Math.max;
import static java.lang.Math.min;

public class GiangVienCoHuu extends Lecturers{
    private long luongcung;
    GiangVienCoHuu(){
    }
    GiangVienCoHuu(String ID,String name,String email, String hocham, String hocvi, String address, String phone, int workingHour, float hesoluong, long luongcung){
        super(ID,name,email, hocham, hocvi,address,phone,workingHour,hesoluong);
        this.luongcung = luongcung;
        this.salary = (this.luongcung + max(0, this.workingHour - 40) * 50000) * this.hesoluong;
    }

    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Lương cứng " + this.luongcung);
    }
}
