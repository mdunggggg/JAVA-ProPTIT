/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.table;

import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ADMIN
 */
public class RoomTableSort extends TableRowSorter<TableModel>{
        private RowFilter<TableModel, Object>filterType;
        private RowFilter<TableModel, Object>filterStatus;
        public RoomTableSort(TableModel model){
            super(model);
            update();
        }
        public void update(){
            if(filterStatus == null && filterType == null) setRowFilter(null);
            else if(filterType != null && filterStatus == null) setRowFilter(filterType);
            else if(filterType == null && filterStatus != null) setRowFilter(filterStatus);
            else setRowFilter(RowFilter.andFilter(Arrays.asList(filterStatus, filterType)));
        }
        public void setFilterType(String key){
            if(key.equals("Tất cả")) filterType = null;
            else filterType = RowFilter.regexFilter(key, 2);
            update();
        }
        public void setFilterStatus(String key){
            if(key.equals("Tất cả")) filterStatus = null;
            else filterStatus = RowFilter.regexFilter(key, 3);
            update();
        }
        public void setFiler(String roomType, String roomStatus){
            setFilterType(roomType);
            setFilterStatus(roomStatus);
            update();
            
        }
    
}
