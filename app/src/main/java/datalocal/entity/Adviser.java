package datalocal.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Adviser implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "MaCoVan")
    private String maCoVan;

    @ColumnInfo(name = "CauHoi")
    private String cauHoi;

    @ColumnInfo(name = "CauTraLoi")
    private String cauTraLoi;

    @ColumnInfo(name = "MaSinhVien")
    private String maSinhVien;

    public Adviser(@NonNull String maCoVan, String cauHoi, String cauTraLoi, String maSinhVien) {
        this.maCoVan = maCoVan;
        this.cauHoi = cauHoi;
        this.cauTraLoi = cauTraLoi;
        this.maSinhVien = maSinhVien;
    }

    @NonNull
    public String getMaCoVan() {
        return maCoVan;
    }

    public void setMaCoVan(@NonNull String maCoVan) {
        this.maCoVan = maCoVan;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
}
