package teacher.service;

import common.*;
import teacher.TeacherRegistrationException;
import teacher.entity.Teacher;

import java.util.Scanner;

public class TeacherService implements RunnableAsMenu {

    @Override
    public void initialize() {
        System.out.println("neche nefer muellim qeydiyyat edeceksiniz?");
        int count = new Scanner(System.in).nextInt();

        Teacher[] teachers = new Teacher[count];

        for(int i=0;i<count;i++) {
            System.out.println("Qeydiyyat nomresi:"+(i+1));
            teachers[i] = requireAndCreate();
        }

        printAll();

        Db.teachers = teachers;
    }

    @Override
    public void initializeNew() {
        Teacher[] oldTeachers = Db.teachers;
        System.out.println("neche nefer yaratmaq isteyirsiniz?");
        int additionalCount = new Scanner(System.in).nextInt();
        Teacher[] newTeachers = new Teacher[oldTeachers.length+additionalCount];
        for(int i=0;i<oldTeachers.length;i++) {
            newTeachers[i] = oldTeachers[i];
        }

        for(int i=oldTeachers.length;i<newTeachers.length;i++) {
            newTeachers[i] = requireAndCreate();
        }


    }

    @Override
    public void update() {
        try{
            System.out.println("nechenci muellimi yenilemek isteyirsen?");
            int updateIndex = new Scanner(System.in).nextInt();
            Teacher teacher = Db.teachers[updateIndex-1];
            System.out.println("hansi xanani update etmek isteyirsen (name, surname, age, salary)");
            String updateField = new Scanner(System.in).nextLine();
            if(updateField.equals("name")) {
               try{
                   System.out.println("adini daxil edin:");
                   teacher.setName(new Scanner(System.in).nextLine());
               } catch (Exception e) {
                   throw new TeacherRegistrationException("name daxil edilen zaman xeta bash verdi", e);
               }
            }else if(updateField.equals("surname")) {
                System.out.println("soyadini daxil edin:");
                teacher.setSurname(new Scanner(System.in).nextLine());
            }else if(updateField.equals("age")) {
                System.out.println("yashini daxil edin:");
                teacher.setAge(new Scanner(System.in).nextInt());
            }else if(updateField.equals("salary")) {
                System.out.println("maashini daxil edin:");
                teacher.setSalary(new Scanner(System.in).nextDouble());
            }

        }catch (Exception e) {
            throw new TeacherRegistrationException(e);
        }
    }

    @Override
    public void delete() {
        System.out.println("nechenci muellimi silmek isteyirsen?");
        int muellimiSil = new Scanner(System.in).nextInt();
        Db.teachers[muellimiSil-1] = null;
    }

    @Override
    public void printAll() {
        Teacher[] teachers = Db.teachers;
        System.out.println("Qeydiyyatdan kechen muellimler.");
        for(int i=0;i<teachers.length;i++) {
            if(teachers[i]==null) continue;
            System.out.println((i+1)+"." +teachers[i]);
        }
    }

    @Override
    public void find() {
        Teacher[] teachers = Db.teachers;
        System.out.println("Axtarmaq istediyiniz muellimin adini ve ya soyadini daxil edin:");
        String text = new Scanner(System.in).nextLine();
        for(int i=0;i<teachers.length;i++) {
            Teacher t = teachers[i];
            if(t==null) continue;

            if(t.getName().equals(text) || t.getSurname().equals(text)) {
                System.out.println(t);
            }
        }
    }

    private Teacher requireAndCreate() {
        Teacher teacher = new Teacher();

        System.out.println("Muellimin adini daxil edin:");
        teacher.setName(new Scanner(System.in).nextLine());

        System.out.println("Muellimin soyadini daxil edin:");
        teacher.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Muellimin yashini daxil edin:");
        teacher.setAge(new Scanner(System.in).nextInt());

        System.out.println("Muellimin maashini daxil edin:");
        teacher.setSalary(new Scanner(System.in).nextDouble());

        return teacher;
    }


}
