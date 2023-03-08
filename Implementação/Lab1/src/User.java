import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

class User {
        private int id;
        private final String email;
        private final String password;

        User(String email, String password) {
                this.email = email;
                this.password = password;
        }

        public User login(List<User> users) throws Error {
                final User[] result = {null};

                users.forEach(user -> {
                        if (Objects.equals(user.email, this.email) && Objects.equals(user.password, this.password)) {
                                result[0] = user;
                        }
                });

                return result[0];
        }

        public User getUser() {
                return this;
        }
}
