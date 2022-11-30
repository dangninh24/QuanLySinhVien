package datalocal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ClassRoom implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "MaLop")
    private String maLop;

    @ColumnInfo(name = "TenLop")
    private String tenLop;

    @ColumnInfo(name = "TaiKhoan")
    private String taiKhoan;

    public ClassRoom(@NonNull String maLop, String tenLop, String taiKhoan) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.taiKhoan = taiKhoan;
    }

    @NonNull
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(@NonNull String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
