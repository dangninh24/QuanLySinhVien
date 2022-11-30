package datalocal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Subject implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "MaMon")
    private String maMon;

    @ColumnInfo(name = "TenMon")
    private String tenMon;

    @ColumnInfo(name = "HocPhi")
    private float hocPhi;

    @ColumnInfo(name = "MaSinhVien")
    private String maSinhVien;

    public Subject(@NonNull String maMon, String tenMon, float hocPhi, String maSinhVien) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hocPhi = hocPhi;
        this.maSinhVien = maSinhVien;
    }

    @NonNull
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(@NonNull String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
}
