public class Registry {
    protected int id;
    protected int subject_id;
    protected int student_id;

    Registry(int id, int subject_id, int student_id) {
        this.id = id;
        this.subject_id = subject_id;
        this.student_id = student_id;
    }

    public static Registry getById(int id) {
        return Database.Registries.stream()
                .filter(registry -> registry.id == id)
                .toList().get(0);
    }
}
