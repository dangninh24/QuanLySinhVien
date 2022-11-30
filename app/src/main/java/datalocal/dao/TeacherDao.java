package datalocal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import datalocal.entity.Teacher;

@Dao
public interface TeacherDao {
    @Insert
    void insertTeacher(Teacher teacher);

    @Query("SELECT * FROM Teacher WHERE TaiKhoan = :acc ")
    Teacher getTeacherByAccount(String acc);
}
