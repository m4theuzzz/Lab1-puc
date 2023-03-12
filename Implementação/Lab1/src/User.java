import java.util.List;
import java.util.Objects;

class User {
        protected int id;
        protected String name;
        protected final String email;
        private String password = null;

        User(int id, String name, String email, String password) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.password = password;
        }

        User(int id, String name, String email) {
                this.id = id;
                this.name = name;
                this.email = email;
        }

        public static User login(String email, String password) throws Exception {
                List<User> found = Database.Users.stream().filter(user -> {
                        if (Objects.equals(user.email, email) && Objects.equals(user.password, password)) {
                                return true;
                        }
                        return false;
                }).toList();

                if (found.size() == 0) {
                        throw new Exception("Incorrect email or password.");
                }

                return found.get(0);
        }
}
