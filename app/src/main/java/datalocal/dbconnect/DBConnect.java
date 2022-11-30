package datalocal.dbconnect;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import datalocal.dao.AccountDao;
import datalocal.dao.AdviserDao;
import datalocal.dao.ClassRoomDao;
import datalocal.dao.StudentDao;
import datalocal.dao.SubjectDao;
import datalocal.dao.TeacherDao;
import datalocal.entity.Account;
import datalocal.entity.Adviser;
import datalocal.entity.ClassRoom;
import datalocal.entity.Student;
import datalocal.entity.Subject;
import datalocal.entity.Teacher;

@Database(entities = {Account.class, Teacher.class, ClassRoom.class, Student.class, Subject.class, Adviser.class}, version = 1)
public abstract class DBConnect extends RoomDatabase {
    public abstract AccountDao getAccountDao();
    public abstract TeacherDao getTeacherDao();
    public abstract ClassRoomDao getClassRoomDao();
    public abstract StudentDao getStudentDao();
    public abstract SubjectDao getSubjectDao();
    public abstract AdviserDao getAdviserDao();
}
