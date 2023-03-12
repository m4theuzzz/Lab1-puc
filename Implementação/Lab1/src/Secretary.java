import java.util.*;
public class Secretary extends User {
    Secretary(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public static Secretary getById(int id) {
        return Database.Users.stream()
                .filter(user -> user.getClass() == Secretary.class && user.id == id)
                .map(user -> (Secretary) user)
                .toList().get(0);
    }

    public List<Subject> getSubjects() {
        return Database.Subjects;
    }

    public List<Registry> getRegistries() {
        return Database.Registries;
    }

    public List<Teacher> getTeachers() {
        return Database.Users.stream().filter(user -> user.getClass() == Teacher.class).map(user -> (Teacher) user).toList();
    }

    public void createTeacher(String name, String email, String password) {
        int id = Database.Users.get(Database.Users.size() - 1).id + 1;
        Teacher newTeacher = new Teacher(id, name, email, password);
        Database.Users.add(newTeacher);
    }

    public List<Student> getStudents() {
        return Database.Users.stream().filter(user -> user.getClass() == Student.class).map(user -> (Student) user).toList();
    }

    public void createStudent(String name, String email, String password, int period) {
        int id = Database.Users.get(Database.Users.size() - 1).id + 1;
        Student newStudent = new Student(id, name, email, password, period);
        Database.Users.add(newStudent);
    }

    public <T extends User> void updateUser(T newData) {
        List<Integer> userIds = Database.Users.stream().map(user -> user.id).toList();
        int index = userIds.indexOf(id);
        Database.Users.set(index, newData);
    }

    public void deleteUser(int id) {
        List<Integer> userIds = Database.Users.stream().map(user -> user.id).toList();
        int index = userIds.indexOf(id);
        Database.Users.remove(index);
    }

    public void createSubject(String name, int period, int hours, double hourPrice, int teacherId, Date start_date, Date end_date) {
        int id = Database.Subjects.get(Database.Subjects.size() - 1).id + 1;
        Subject subject = new Subject(id, name, new ArrayList<Integer>(), period, hours,true, hourPrice, teacherId, start_date, end_date);
        Database.Subjects.add(subject);
    }

    private Billing buildRegistryBill(int student_id) {
        List<Registry> studentRegistries = Database.Registries.stream().filter(registry -> registry.student_id == student_id).toList();
        double totalToPay = getRegistriesSum(studentRegistries);
        int billingId = Database.Billings.size() + 1;
        Billing billing = new Billing(billingId, totalToPay, student_id);
        Database.Billings.add(billing);
        return billing;
    }

    public void sendStudentsBill() {
        Database.Users.stream().filter(user -> user.getClass() == Student.class).forEach(student -> {
            Billing bill = this.buildRegistryBill(student.id);
            bill.sendBill();
        });
    }

    public void updateSubjectRegistryPeriod(int subject_id, Date start_date, Date end_date) {
        List<Integer> subjectIds = Database.Subjects.stream().map(subject -> subject_id).toList();
        int index = subjectIds.indexOf(subject_id);
        Subject subject = Database.Subjects.get(index);

        subject.setNewRegistryDates(start_date, end_date);
        Database.Subjects.set(index, subject);
    }

    private double getRegistriesSum(List<Registry> registries) {
        double sum = 0.0;
        List<Integer> subjectsIndex = Database.Subjects.stream().map(subject -> subject.id).toList();
        for (int i=0; i < registries.size(); i++) {
            int subjectIndex = subjectsIndex.indexOf(registries.get(i).subject_id);
            Subject subject = Database.Subjects.get(subjectIndex);
            sum += (subject.hours * subject.hourPrice);
        }
        return sum;
    }

    public void buildGrade(List<Integer> mandatory, List<Integer> optional, int period) throws Exception {
        if(validateGradeSubjects(mandatory, optional, period)){
            int id = Database.Grades.get(Database.Grades.size() - 1).id + 1;
            Grade newGrade = new Grade(id, mandatory, optional, period);
            Database.Grades.add(newGrade);
        }
    }

    public void updateGrade(int id, List<Integer> mandatory, List<Integer> optional, int period) throws Exception {
        if (validateGradeSubjects(mandatory, optional, period)) {
            int index = Database.Grades.stream().map(grade -> grade.id).toList().indexOf(id);
            Grade newGrade = new Grade(id, mandatory, optional, period);
            Database.Grades.set(index, newGrade);
        }
    }

    private boolean validateGradeSubjects(List<Integer> mandatory, List<Integer> optional, int period) throws Exception {
        if (mandatory.size() < 1 || mandatory.size() > 4) {
            throw new Exception("Grades must have at least 1 and maximum 4 mandatory subjects.");
        }
        if (optional.size() > 2) {
            throw new Exception("Grades must have 2 or less optional subjects.");
        }
        if (Database.Grades.stream().map(grade -> grade.period).toList().contains(period)) {
            throw new Exception("There can be only one grade per period.");
        }

        return true;
    }

}
