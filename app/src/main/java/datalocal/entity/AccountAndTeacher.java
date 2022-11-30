package datalocal.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;

public class AccountAndTeacher implements Serializable {
    @Embedded public Account account;
    @Relation(
            parentColumn = "TaiKhoan",
            entityColumn = "TaiKhoan"
    )
    public Teacher teacher;
}
