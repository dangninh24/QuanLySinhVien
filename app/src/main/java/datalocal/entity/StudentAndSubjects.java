package datalocal.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

public class StudentAndSubjects implements Serializable {
    @Embedded
    public Student student;
    @Relation(
            parentColumn = "MaSinhVien",
            entityColumn = "MaSinhVien"
    )
    public List<Subject> subjectList;
}
