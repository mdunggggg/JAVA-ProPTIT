/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.table;


import Model.Room;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADMIN
 */
public class RoomTableModel extends AbstractTableModel{
    private final List<Room>rooms;
    private final String[] columnNames;
 
    public RoomTableModel(){
        rooms = new ArrayList<>();
        columnNames = new String[]{"Mã phòng", "Tên phòng", "Loại phòng", "Tình trạng"};
        fakeInfor();
    }

    @Override
    public int getRowCount() {
        return rooms.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room room = rooms.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return room.getId();
            } 
            case 1 -> {
                return room.getName();
            }
            case 2 -> {
                return room.getType();
            }
            case 3 -> {
                if(room.isRented() == true) return "ĐÃ ĐẶT";
                else return "CÒN TRỐNG";
            }
            default -> throw new AssertionError();
        }
        // return
            }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    public void addRoom(String name, String type){
        Room room = new Room(name, type);
        rooms.add(room);
        fireTableDataChanged();
    }
    public Room findRoom(String id){
        for(Room room : rooms){
            if(room.getId().equals(id))
                 return room;
        }
        return null;
    }
    void fakeInfor(){
        rooms.add(new Room("Phòng 1", "VIP"));
        rooms.add(new Room("Phòng 2", "VIP"));
        rooms.add(new Room("Phòng 3", "VIP"));
        rooms.add(new Room("Phòng 4", "VIP"));
        rooms.add(new Room("Phòng 5", "VIP"));
        fireTableDataChanged();
    }
}
