/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.ComboBox;

import Model.Room;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ADMIN
 */
public class RoomComboBoxModel extends DefaultComboBoxModel{
     public RoomComboBoxModel() {
        super(Room.RoomType.values());
    }
    @Override
    public Room.RoomType getSelectedItem() {
        return ((Room.RoomType)super.getSelectedItem());
    }
    
}
