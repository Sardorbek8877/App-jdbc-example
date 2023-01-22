package uz.pdp;

import java.sql.*;

public class DataBaseService {

    private String url = "jdbc:postgresql://localhost:5432/app-jdbc-example";
    private String dbUser = "postgres";
    private String dbPassword = "123";

    public void saveUser(User user){

        try {
            Connection boglovchi = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement statement = boglovchi.createStatement();
            String query = "Insert into users(firstname, lastname, username, password) " +
                    "values('" + user.getFirstname() + "','" + user.getLastname() +
                    "','" + user.getUsername() + "','" + user.getPassword() + "');";

            statement.execute(query);
            System.out.println("User added.");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getUsers(){
        Connection boglovchi = null;
        try {
            boglovchi = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement statement = boglovchi.createStatement();
            String query = "select * from users";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString(3);
                String username = resultSet.getString("username");
                String password = resultSet.getString(5);
                User user = new User(id, firstname, lastname, username, password);
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteUser(int userId){
        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement statement= connection.createStatement();
            String query = "delete from users where id="+userId;
            boolean execute = statement.execute(query);
            System.out.println("User deleted!");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
