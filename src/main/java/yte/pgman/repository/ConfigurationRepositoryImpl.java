package yte.pgman.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import yte.pgman.repository.pojo.Configuration;

import java.sql.*;


@Repository
public class ConfigurationRepositoryImpl implements ConfigurationRepository {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public void saveConfiguration(Configuration configuration) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pgman(xxx, yyy, zzz) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, configuration.getId());
        preparedStatement.setString(2, configuration.getKey());
        preparedStatement.setString(3, configuration.getValue());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public Configuration getConfigurationWithID(int id) throws SQLException {
        String key = "";
        String value= "";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pgman WHERE xxx=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            key = resultSet.getString("yyy");
            value= resultSet.getString("zzz");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return new Configuration(id, key, value);
    }
}
