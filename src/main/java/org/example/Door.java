package org.example;


import org.example.enums.ObjectBehindDoor;

public class Door {
    private ObjectBehindDoor objectBehindDoor;


    public Door() {
        this.objectBehindDoor = ObjectBehindDoor.GOAT;
    }


    public ObjectBehindDoor getObjectBehindDoor() {
        return objectBehindDoor;
    }


    public void setObjectBehindDoor(ObjectBehindDoor objectBehindDoor) {
        this.objectBehindDoor = objectBehindDoor;
    }



    @Override
    public String toString() {
        return objectBehindDoor + " ";
    }
}
