/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.table;

import Model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ADMIN
 */
public class CustomerTableSort extends TableRowSorter<TableModel>{
    private Customer.CustomerSort sortType;
    private static List<RowSorter.SortKey>sortByID, sortByName, sortByRentDate;
    public CustomerTableSort(TableModel model){
        super(model);
        sortType = Customer.CustomerSort.ID;
        if(sortByID == null){
            sortByID = new ArrayList<>();
            sortByID.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        }
        if(sortByName == null){
           sortByName = new ArrayList<>();
           sortByName.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        }
        if(sortByID == null){
            sortByRentDate = new ArrayList<>();
            sortByRentDate.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));
        }
        
    }
    public void setFilter(String key){
          if(key.equals(""))setRowFilter(null);
          else  setRowFilter(RowFilter.regexFilter(key, 1)); 
    }
    public void setSortType(Customer.CustomerSort sortType){
      
        this.sortType = this.sortType;
        switch(sortType){
            case ID:
                setSortKeys(sortByID);
                break;
           case Name:
                setSortKeys(sortByName);
                break;
           case RentDate:
                setSortKeys(sortByRentDate);
                break;     
        }
    }
}
