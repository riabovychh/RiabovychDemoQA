package page.elements;

import org.riabovych.page.page.elements.UploadAndDownloadPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EachPageTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class UploadAndDownloadPageTest extends EachPageTest {

    private UploadAndDownloadPage uploadAndDownloadPage ;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/upload-download");
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        uploadAndDownloadPage = null;

    }

    @Test
    public void testUploadFile() {
//        ClassLoader.getSystemResource("test_file.txt");
        String pathToFile = "/Users/tetianariabovych/IdeaProjects/RiabovychDemoQA/src/main/resources/test_file.txt";
        uploadAndDownloadPage.uploadFile(pathToFile);
    }

    @Test
    public void downloadTest() throws InterruptedException {
        int expectedCount = 1;
        int coutFiles = downloadsFolder.list().length;  //
        Assert.assertEquals(coutFiles,0);
        uploadAndDownloadPage.clickDownloadButton();
        int actualCount = downloadsFolder.list().length;
        Assert.assertEquals(actualCount, expectedCount);

        for (File file : downloadsFolder.listFiles()){
            Assert.assertTrue(file.getName().contains("sampleFile"));

            // проверка, что файл загрузился за последние 10 минут
            try {
               BasicFileAttributes attributes =  Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                Instant creationTime = attributes.creationTime().toInstant();
                Instant tenMinutesBefore = Instant.now().minus(10, ChronoUnit.MINUTES);
                Assert.assertTrue(creationTime.isAfter(tenMinutesBefore));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
//        DOWNLOADS.listFiles()[0].getName();

//        Thread.sleep(10000);
//        File downloadedFile = new File("/Users/tetianariabovych/Downloads/sampleFile.jpeg");
//        boolean exists = downloadedFile.exists();
//        System.out.println(exists);

    }
}