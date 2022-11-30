package datalocal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import datalocal.entity.ClassRoom;

@Dao
public interface ClassRoomDao {
    @Insert
    void insertClassRoom(ClassRoom classRoom);

    @Query("SELECT * FROM ClassRoom WHERE TaiKhoan = :acc")
    List<ClassRoom> getListClassRoom(String acc);

}
