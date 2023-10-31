package org.ames.dao;

import org.ames.bean.Sample;
import org.ames.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SampleDao {
    public List<Sample> getByName(String name) {
        List<Sample> sampleList = new ArrayList<>();
        String sql = "select * from sample where name = ?";
        try (
                // those are all auto closeable
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int age = resultSet.getInt("AGE");
                sampleList.add(new Sample(name, age));
            }
            return sampleList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sample> getByAge(int age) {
        String sql = "select * from sample where age = ?";
        List<Sample> sampleList = new ArrayList<>();
        try (
                // those are all auto closeable
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                sampleList.add(new Sample(name, age));
            }
            return sampleList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sample> getSamplesOverAge(int target) {
        String sql = "select * from sample where age > ?";
        List<Sample> sampleList = new ArrayList<>();
        try (
                // those are all auto closeable
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, target);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                sampleList.add(new Sample(name, age));
            }
            return sampleList;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            e.printStackTrace();
        }
        return sampleList;
    }
}
