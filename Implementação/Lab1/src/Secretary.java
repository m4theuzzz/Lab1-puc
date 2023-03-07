public class Secretary extends User {
    Secretary(String email, String password) {
        super(email, password);
    }

    public Grade buildGrade() {
    }

    public List<Teacher> getTeachers() {
    }

    public List<Student> getStudents() {
    }

    public List<Classes> getClasses() {
    }

    public List<Registries> getRegistries() {
    }

    public Billing buildRegistryBill(int student_id) {
    }

    public Secretary getSecretary() {
        return this;

    }

}
