package org.ames.dao;

import org.ames.bean.Sample;
import org.ames.util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SampleDao {
    public Sample get(String name) {
        return null;
    }

    public List<Sample> getByAge(int age) {
        return null;
    }

    public List<Sample> getSamplesOverAge(int age) {
        return null;
    }

    public List<Sample> insertSample() {
        return null;
    }

    public List<Sample> insertSampleBatch(List<Sample> samples) {
        return null;
    }

    public List<Sample> getAll() {
        List<Sample> sampleList = new ArrayList<>();
        String sql = "select * from sample";
        try (
                // those are all auto closeable
                Connection connection = JdbcUtil.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                sampleList.add(new Sample(name, age));
            }
        } catch (Exception e) {

        }
        return sampleList;
    }
}
