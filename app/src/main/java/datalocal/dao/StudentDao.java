package datalocal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import datalocal.entity.Student;

@Dao
public interface StudentDao {
    @Insert
    void insertStudent(Student student);

    @Query("SELECT * FROM Student")
    List<Student> getListStudent();
}
