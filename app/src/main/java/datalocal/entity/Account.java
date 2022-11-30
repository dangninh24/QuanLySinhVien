package datalocal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Account implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "TaiKhoan")
    private String taiKhoan;
    @ColumnInfo(name = "MatKhau")
    private String matKhau;

    public Account(@NonNull String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    @NonNull
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(@NonNull String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
