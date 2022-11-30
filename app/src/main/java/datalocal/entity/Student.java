package datalocal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "MaSinhVien")
    private String maSinhVien;

    @ColumnInfo(name = "TenSinhVien")
    private String tenSinhVien;

    @ColumnInfo(name = "MaLop")
    private String maLop;

    public Student(@NonNull String maSinhVien, String tenSinhVien, String maLop) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.maLop = maLop;
    }

    @NonNull
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(@NonNull String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}
