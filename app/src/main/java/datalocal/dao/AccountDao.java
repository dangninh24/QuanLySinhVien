package datalocal.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import datalocal.entity.Account;

@Dao
public interface AccountDao {
    @Insert
    void insertAccount(Account account);

    @Query("SELECT * FROM Account")
    List<Account> getListAccount();

    @Query("SELECT * FROM Account WHERE TaiKhoan = :acc AND MatKhau = :pass")
    Account getListAccountByAccAndPass(String acc, String pass);

}
