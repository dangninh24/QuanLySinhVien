package datalocal.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

public class ClassRoomAndStudents implements Serializable {
    @Embedded
    public ClassRoom classRoom;
    @Relation(
            parentColumn = "MaLop",
            entityColumn = "MaLop"
    )
    public List<Student> studentList;
}
