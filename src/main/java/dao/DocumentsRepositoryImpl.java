package dao;

import common.interfaces.DocumentsRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DocumentsRepositoryImpl implements DocumentsRepository {

    private final String QUERY_FIND_ALL = "select * from documents";
    private final String COLUMN_NAME = "doc_name";

    static final String DB_URL = "jdbc:postgresql://ruby.db.elephantsql.com:5432/mpqcrtjm";
    static final String USER = "mpqcrtjm";
    static final String PASS = "gi8j7WREWlNOEHvAIOJY8z2YyHgWr-8l";

    @Override
    public Optional<List<String>> findAll(){
        List<String> documents = new ArrayList<>();
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ALL);
            while (resultSet.next()) {
                documents.add(resultSet.getString(COLUMN_NAME));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(documents);
    }
}
