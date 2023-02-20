package Model;

import java.io.Serializable;

public class Room implements Serializable {
    public static int NUM_ROOM = 0;
    private String idRoom;
    private String nameRoom;
    private String typeRoom;
    private boolean isEmpty;


    public Room(String nameRoom, String typeRoom) {
        this.idRoom = "0".repeat(3 - String.valueOf(++NUM_ROOM).length()) + NUM_ROOM;
        this.nameRoom = nameRoom;
        this.typeRoom = typeRoom;
        this.isEmpty = true;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }
    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }


    @Override
    public String toString() {
        return "Room{" +
                "idRoom='" + idRoom + '\'' +
                ", nameRoom='" + nameRoom + '\'' +
                ", typeRoom='" + typeRoom + '\'' +
                '}';
    }
}
