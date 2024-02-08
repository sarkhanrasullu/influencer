import common.Db;
import common.Person;
import file.FileUtility;
import teacher.entity.Teacher;
import teacher.service.TeacherService;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class Main {


    public static void main(String[] args) {
            try{
                Object o = FileUtility.readObject("teachers.obj");
                Teacher[] teachers = (Teacher[]) o;

                Db.teachers = teachers;
                //
            } catch (Exception ignored) {
                //
            }

        TeacherService service = new TeacherService();
        service.showMenu();
    }

}