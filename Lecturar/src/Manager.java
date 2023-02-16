import java.util.*;

public class Manager {
    private static List<Lecturers> listLectures = new ArrayList<>();
    public void menu(){
        System.out.println("*_____MENU______*");
        System.out.println("1.Thêm giảng viên ");
        System.out.println("2.In danh sách giảng viên.");
        System.out.println("3.Xoá, sửa giảng viên (Theo ID).");
        System.out.println("4.In danh sách giảng viên cơ hữu");
        System.out.println("5.In danh sách giảng viên thỉnh giảng");
        System.out.println("6.Tìm kiếm giảng viên(gần đúng)");
        System.out.println("7.Sắp xếp (Tên, lương ");
        System.out.println("8.Tổng tiền lương ");
        System.out.println("Giảng viên có lương cao nhất");
        System.out.println("0.Thoát.");
        System.out.print("Mời bạn chọn:");
    }
    public void run(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true){
            menu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addLecture();
                    break;
                case 2:
                    showLecturar();
                    break;
                case 3:
                    EraseOrEditLecture();
                    break;
                case 4:
                    dsGiangVienCoHuu();
                    break;
                case 5:
                    dsGiangVienThinhGiang();
                    break;
                case 6:
                    break;
                case 7:
                    sortLectures();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    return;
            }
        }
    }
    public void addLecture(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap giang vien can them");
        System.out.println("1. Giang vien co huu    2.Giang vien thinh giang");
        int choice;
        choice = scanner.nextInt();
        scanner.nextLine();
        String ID, name, email, hocham, hocvi, address, phone;
        int workingHour;
        float hesoluong;
        System.out.println("Nhap ID ");
        ID = scanner.nextLine();
        System.out.println("Nhap ten: ");
        name = scanner.nextLine();
        System.out.println("Nhap email: ");
        email = scanner.nextLine();
        System.out.println("Nhap học hàm(no, pgs, gs):");
        hocham = scanner.nextLine();
        System.out.println("Nhập học vị(daihoc, thacsy, tiensy)");
        hocvi = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        address = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        phone = scanner.nextLine();
        System.out.println("Nhập số giờ làm việc: ");
        workingHour = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập hệ số lương ");
        hesoluong = scanner.nextFloat();
        Lecturers lecture;
        if(choice == 1){
            long luongcung;
            System.out.println("Nhập lương cứng: ");
            luongcung = scanner.nextLong();
            lecture = new GiangVienCoHuu(ID,name,email, hocham, hocvi,address,phone,workingHour,hesoluong, luongcung);
            listLectures.add(lecture);
        }
        else{
            String workAddress, phoneOffice;
            System.out.println("Nhập địa chỉ cơ quan: ");
            workAddress = scanner.nextLine();
            System.out.println("Nhập số điện thoại cơ quan: ");
            phoneOffice = scanner.next();
            lecture = new GiangVienThinhGiang(ID,name,email, hocham, hocvi,address,phone,workingHour,hesoluong,workAddress,phoneOffice);
        }
    }
    public void showLecturar(){
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        System.out.println("Danh sách giảng viên cơ hữu: ");
        for(Lecturers lecturer : listLectures){
            if(lecturer instanceof GiangVienCoHuu){
                lecturer.showInfor();
                ++num;
            }
        }
        System.out.println("Danh sách giảng viên thỉnh giảng: ");
        for(Lecturers lecture : listLectures){
            if(lecture instanceof GiangVienThinhGiang){
                lecture.showInfor();
                ++num;
            }
        }
        System.out.println("Tổng số giảng viên: " + num);
    }
    public void editLecture(Lecturers lecturer){

    }
    public void EraseOrEditLecture(){
        String ID;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Xoá      2.Sửa");
        int choice;
        choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap ID: ");
        ID = scanner.next();
        for(int i = 0 ; i < listLectures.size() ; ++i){
            if(listLectures.get(i).getID().equals(ID)){
                if(choice == 1){
                    listLectures.remove(i);
                    System.out.println("Xoa thanh cong!!!!!");
                    return;
                }else{
                    editLecture(listLectures.get(i));
                    System.out.println("Sua thanh cong!!!!");
                    return;
                }

            }
        }
    }
    public void dsGiangVienCoHuu(){
        int num = 0;
        System.out.println("Danh sách giảng viên cơ hữu: ");
        for(Lecturers lecturer : listLectures){
            if(lecturer instanceof GiangVienCoHuu){
                lecturer.showInfor();
                ++num;
            }
        }
        System.out.println("Tong so giang vien co huu: " + num);
    }
    public void dsGiangVienThinhGiang(){
        int num = 0;
        System.out.println("Danh sách giảng viên thỉnh giảng: ");
        for(Lecturers lecturer : listLectures){
            if(lecturer instanceof GiangVienThinhGiang){
                lecturer.showInfor();
                ++num;
            }
        }
        System.out.println("Tong so giang vien thinh giang: " + num);
    }
    void sortLectures(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sap xep theo: ");
        System.out.println("1.Ten   2. Luong");
        choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1){
            Collections.sort(listLectures, new Comparator<Lecturers>() {
                @Override
                public int compare(Lecturers o1, Lecturers o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }
        else{
            Collections.sort(listLectures, new Comparator<Lecturers>() {
                @Override
                public int compare(Lecturers o1, Lecturers o2) {
                    if(o1.getSalary() == o2.getSalary()) return 0;
                    else if(o1.getSalary() > o2.getSalary()) return -1;
                    else return 1;
                }
            });
        }
    }

}
