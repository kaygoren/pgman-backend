package yte.pgman.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgresql;

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
    public void saveConfigurationPostgresql(ConfigurationPostgresql configurationPostgresql) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pgman_postgresql(key, value) VALUES (?, ?)");
//        preparedStatement.setInt(1, configuration.getId());
        preparedStatement.setString(1, configurationPostgresql.getKey());
        preparedStatement.setString(2, configurationPostgresql.getValue());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void saveConfigurationPghba(ConfigurationPghba configurationPghba) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pgman_pghba(type, database, cuser, address, method) VALUES (?, ?, ?, ?, ?)");
//        preparedStatement.setInt(1, configuration.getId());
        preparedStatement.setString(1, configurationPghba.getType());
        preparedStatement.setString(2, configurationPghba.getDatabase());
        preparedStatement.setString(3, configurationPghba.getUser());
        preparedStatement.setString(4, configurationPghba.getAddress());
        preparedStatement.setString(5, configurationPghba.getMethod());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    @Override
    public ConfigurationPostgresql getConfigurationWithID(int id) throws SQLException {
        String key = "";
        String value= "";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pgman_postgresql WHERE xxx=?");
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

        return new ConfigurationPostgresql(id, key, value);
    }
}
