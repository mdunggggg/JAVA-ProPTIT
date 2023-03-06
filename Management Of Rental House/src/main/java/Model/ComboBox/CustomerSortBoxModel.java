/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.ComboBox;

import Model.Customer;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ADMIN
 */
public class CustomerSortBoxModel extends DefaultComboBoxModel{
    public CustomerSortBoxModel(){
        super(Customer.CustomerSort.values());
    }

    @Override
    public Object getSelectedItem() {
        return ((Customer.CustomerSort)super.getSelectedItem());
    }
    
    
}
