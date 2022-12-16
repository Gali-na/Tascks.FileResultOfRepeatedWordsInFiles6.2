package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileFunctionTest {

    @Test
    void readFileIsNull_GetEmptyList() {
        File file = null;
        assertEquals(0, (FileFunction.read(file)).size());
    }

    @Test
    void readFileExist_GetListWithString() {
        File file = new File("TestFile");
        assertEquals(1, (FileFunction.read(file)).size());
    }

    @Test
    void searchTheSameWords_FilesIsNull_GetEmptyList() {
        File fileTestOne = null;
        File fileTestSecond = null;
        assertEquals(0, (FileFunction.searchTheSameWords(fileTestOne, fileTestSecond).length()));
    }

    @Test
    void searchTheSameWords_FilesIsEmpty_GetEmptyList() {
        File fileTestOne = new File("TestFile");
        File fileTestSecond = new File("TestFile");
        assertEquals(0, (FileFunction.searchTheSameWords(fileTestOne, fileTestSecond).length()));
    }

    @Test
    void searchTheSameWords_FilesIsNotEmpty_GetStringWithInformatioFromFile() {
        File fileTestOne = new File("TestFile");
        File fileTestSecond = new File("TestFileSecond.txt");
        assertEquals("Any ", (FileFunction.searchTheSameWords(fileTestOne, fileTestSecond)));
    }

    @Test
    void write() {
        File fileTestOne = new File("TestFile");
        File fileTestSecond = new File("TestFileSecond.txt");
        File RezultFileTest = new File("RezultFileTest.txt");
        FileFunction.write(fileTestOne, fileTestSecond, RezultFileTest);
        List<String> rezultReading = FileFunction.read(RezultFileTest);
        assertEquals("Any", rezultReading.get(0));
    }

    @Test
    void checkFile_FileIsNull_GetFalse() {
        File file = null;
        assertEquals(false, FileFunction.checkFile(file));
    }

    @Test
    void checkFile_FileIsNotFile_GetFalse() {
        File file = new File("C:\\Users");
        assertEquals(false, FileFunction.checkFile(file));
    }

    @Test
    void checkFile_FileIsExist_GetTrue() {
        File file = new File("First File.txt");
        assertEquals(true, FileFunction.checkFile(file));
    }
}