package Controller;

public class Util {
    public static String normalizeName(String name) {
        var word = name.toLowerCase().trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            stringBuilder.append(word[i].substring(0, 1).toUpperCase()).append(word[i].substring(1));
            if (i != word.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
    public static boolean checkCustomerType(String typeOfCustomer){
        return typeOfCustomer.equalsIgnoreCase("Student") ||
                typeOfCustomer.equalsIgnoreCase("Family") ||
                typeOfCustomer.equalsIgnoreCase("Enterprise");

    }
    public static boolean checkRoomType(String roomType){
        return roomType.equalsIgnoreCase("Vip") ||
                roomType.equalsIgnoreCase("Normal") ||
                roomType.equalsIgnoreCase("High quality");
    }

}
