package datalocal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Teacher implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "TaiKhoan")
    @NonNull
    private String taiKhoan;

    @ColumnInfo(name = "TenGiaoVien")
    private String tenGiaoVien;

    @ColumnInfo(name = "AnhGiaoVien")
    private int anhGiaoVien;

    @ColumnInfo(name = "NgaySinh")
    private String ngaySinh;

    @ColumnInfo(name = "GioiTinh")
    private String gioiTinh;

    @ColumnInfo(name = "NoiSinh")
    private String noiSinh;

    @ColumnInfo(name = "CCCd")
    private String CCCD;

    @ColumnInfo(name = "TinhTrangHonNhan")
    private String tinhTrangHonNhan;

    @ColumnInfo(name = "SoDienThoai")
    private String soDienThoai;

    @ColumnInfo(name = "TrinhDo")
    private String trinhDo;

    @ColumnInfo(name = "PhongBan")
    private String phongBan;

    @ColumnInfo(name = "Email")
    private String email;

    public Teacher(@NonNull String taiKhoan, String tenGiaoVien, int anhGiaoVien, String ngaySinh, String gioiTinh, String noiSinh, String CCCD, String tinhTrangHonNhan, String soDienThoai, String trinhDo, String phongBan, String email) {
        this.taiKhoan = taiKhoan;
        this.tenGiaoVien = tenGiaoVien;
        this.anhGiaoVien = anhGiaoVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.CCCD = CCCD;
        this.tinhTrangHonNhan = tinhTrangHonNhan;
        this.soDienThoai = soDienThoai;
        this.trinhDo = trinhDo;
        this.phongBan = phongBan;
        this.email = email;
    }

    public int getAnhGiaoVien() {
        return anhGiaoVien;
    }

    public void setAnhGiaoVien(int anhGiaoVien) {
        this.anhGiaoVien = anhGiaoVien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @NonNull
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(@NonNull String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
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

    public String getTinhTrangHonNhan() {
        return tinhTrangHonNhan;
    }

    public void setTinhTrangHonNhan(String tinhTrangHonNhan) {
        this.tinhTrangHonNhan = tinhTrangHonNhan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
