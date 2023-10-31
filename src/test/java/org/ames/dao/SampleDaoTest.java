package org.ames.dao;

import org.ames.bean.Sample;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SampleDaoTest {

    @Test
    public void testGetByName() {
        SampleDao sampleDao = new SampleDao();
        List<Sample> sampleList = sampleDao.getByName("jack");
        System.out.println(sampleList);
        assertNotNull(sampleList);
    }

    @Test
    public void testGetByAge() {
        SampleDao sampleDao = new SampleDao();
        List<Sample> sampleList = sampleDao.getByAge(18);
        System.out.println(sampleList);
        // TODO: it seems this doesn't work even if I enter 17
        assertNotNull(sampleList);
    }

    @Test
    public void testGetSampleOverAge() {
        SampleDao sampleDao = new SampleDao();
        List<Sample> sampleList = sampleDao.getSamplesOverAge(17);
        System.out.println(sampleList);
    }

    @Test
    public void testInsertSample() {
        String testName = "John";
        int testAge = 25;
        SampleDao sampleDao = new SampleDao();
        sampleDao.insertSample(testName, testAge);
    }

    @Test
    public void testInsertSampleBatch() {
        SampleDao sampleDao = new SampleDao();
        List<Sample> sampleList = new ArrayList<>();
        sampleList.add(new Sample("Mia", 21));
        sampleList.add(new Sample("Tom", 40));
        sampleDao.insertSampleBatch(sampleList);
    }

    @Test
    public void testGetAll() {
        SampleDao sampleDao = new SampleDao();
        List<Sample> samples = sampleDao.getAll();
        sampleDao.getAll().forEach(System.out::println);
        assertNotNull(samples);
    }

}
