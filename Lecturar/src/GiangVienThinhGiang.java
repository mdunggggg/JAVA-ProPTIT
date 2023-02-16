public class GiangVienThinhGiang extends Lecturers{
    private String workAddress, phoneOffice;
    GiangVienThinhGiang(){
    }
    GiangVienThinhGiang(String ID,String name,String email, String hocham, String hocvi, String address, String phone, int workingHour, float hesoluong, String workAddress, String phoneOffice){
        super(ID,name,email, hocham, hocvi,address,phone,workingHour,hesoluong);
        this.workAddress = workAddress;
        this.phoneOffice = phoneOffice;
        this.salary = 200000 * this.hesoluong * this.workingHour;
    }

    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Địa chỉ cơ quan " + this.workAddress);
        System.out.println("Số điện thoại cơ quan " + this.phoneOffice);
    }
}
