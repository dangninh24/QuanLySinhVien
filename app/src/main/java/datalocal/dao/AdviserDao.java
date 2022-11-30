package datalocal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import datalocal.entity.Adviser;

@Dao
public interface AdviserDao {
    @Insert
    void insertAdviser(Adviser adviser);

    @Query("SELECT * FROM Adviser")
    List<Adviser> getListAdviser();

    @Update
    void updateAdviser(Adviser adviser);
}
