package datalocal.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

public class TeacherAndClassRooms implements Serializable {
    @Embedded
    public Teacher teacher;
    @Relation(
            parentColumn = "TaiKhoan",
            entityColumn = "TaiKhoan"
    )
    public List<ClassRoom> classRoomList;
}
