package datalocal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import datalocal.entity.Subject;

@Dao
public interface SubjectDao {
    @Insert
    void insertSubject(Subject subject);

    @Query("SELECT * FROM Subject WHERE MaSinhVien =:id")
    List<Subject> getListSubjectByIdStudent(String id);
}
