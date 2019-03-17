package pac1;

import javax.persistence.*;

/**
 * Created by Helig on 29.12.2018.
 */
@Entity
@Table(name = "users", schema = "new_schema", catalog = "")
public class UsersEntity {
    private int idUsers;
    private String usersName;
    private String password;

    @Id
    @Column(name = "idUsers")
    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Basic
    @Column(name = "UsersName")
    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUsers != that.idUsers) return false;
        if (usersName != null ? !usersName.equals(that.usersName) : that.usersName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsers;
        result = 31 * result + (usersName != null ? usersName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
