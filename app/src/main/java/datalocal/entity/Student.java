package datalocal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.quanlysinhvien.R;

import java.io.Serializable;

@Entity
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "MaSinhVien")
    private String maSinhVien;

    @ColumnInfo(name = "TenSinhVien")
    private String tenSinhVien;

    @ColumnInfo(name = "AnhSinhVien")
    private int anhSinhVien;

    @ColumnInfo(name = "MaLop")
    private String maLop;

    @ColumnInfo(name = "NgaySinh")
    private String ngaySinh;

    @ColumnInfo(name = "GioiTinh")
    private String gioiTinh;

    @ColumnInfo(name = "NoiSinh")
    private String noiSinh;

    @ColumnInfo(name = "CCCD")
    private String CCCD;

    @ColumnInfo(name = "SoDienThoai")
    private String soDienThoai;

    @ColumnInfo(name = "Email")
    private String email;

    @ColumnInfo(name = "Khoa")
    private String khoa;

    public Student(@NonNull String maSinhVien, String tenSinhVien, String maLop, String ngaySinh, String gioiTinh, String noiSinh, String CCCD, String soDienThoai, String email, String khoa) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        if(tenSinhVien.equals("Nam")) {
            this.anhSinhVien = R.drawable.boy;
        } else {
            this.anhSinhVien = R.drawable.girl;
        }
        this.maLop = maLop;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.CCCD = CCCD;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.khoa = khoa;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getAnhSinhVien() {
        return anhSinhVien;
    }

    public void setAnhSinhVien(int anhSinhVien) {
        this.anhSinhVien = anhSinhVien;
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
