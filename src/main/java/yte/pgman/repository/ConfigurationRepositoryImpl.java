package yte.pgman.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import yte.pgman.repository.pojo.ConfigurationPghba;
import yte.pgman.repository.pojo.ConfigurationPostgres;

import java.sql.*;
import java.util.List;


@Repository
public class ConfigurationRepositoryImpl implements ConfigurationRepository {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public void savePostgresConf(String operation, String tableName, List<ConfigurationPostgres> configurationPostgresList) throws SQLException {

        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement;
        if(operation.equals("add")) {
            preparedStatement = connection.prepareStatement("CREATE TABLE " + tableName + "(key VARCHAR(255) , value VARCHAR(255));");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else if(operation.equals("replace")) {
            preparedStatement= connection.prepareStatement("TRUNCATE TABLE " + tableName+";");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        for (ConfigurationPostgres configurationPostgres: configurationPostgresList) {
            preparedStatement = connection.prepareStatement("INSERT INTO "+tableName+"(key, value) VALUES (?, ?)");
            preparedStatement.setString(1, configurationPostgres.getKey());
            preparedStatement.setString(2, configurationPostgres.getValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.close();
    }

    @Override
    public void savePghbaConf(String operation, String tableName, List<ConfigurationPghba> configurationPghbaList) throws SQLException {

        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement;
        if(operation.equals("add")) {
            preparedStatement = connection.prepareStatement("CREATE TABLE " + tableName + "(type VARCHAR(255) , database VARCHAR(255) , cuser VARCHAR(255) , address VARCHAR(255) , method VARCHAR(255));");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        else if(operation.equals("replace")) {
            preparedStatement= connection.prepareStatement("TRUNCATE TABLE " + tableName+";");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        for(ConfigurationPghba configurationPghba: configurationPghbaList) {
            preparedStatement = connection.prepareStatement("INSERT INTO "+tableName+"(type, database, cuser, address, method) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, configurationPghba.getType());
            preparedStatement.setString(2, configurationPghba.getDatabase());
            preparedStatement.setString(3, configurationPghba.getUser());
            preparedStatement.setString(4, configurationPghba.getAddress());
            preparedStatement.setString(5, configurationPghba.getMethod());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.close();
    }

    @Override
    public ConfigurationPostgres getPostgresConfigurationWithID(int id) throws SQLException {
        String key = "";
        String value= "";
        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pgman_postgresql WHERE xxx=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            key = resultSet.getString("key");
            value= resultSet.getString("value");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return new ConfigurationPostgres(id, key, value);
    }

}
