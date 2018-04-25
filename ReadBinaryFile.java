
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S1
 */
public class ReadBinaryFile {
    public byte[] bytes;
    public String outputFile;
    public String inputFile;
    public int key;

    public ReadBinaryFile(String inputFile, String outputFile, int key) throws IOException {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.key = key;
        bytes = readSmallBinaryFile(this.inputFile);
        byte[] shifted = encrypt();
        log("Small - size of file read in:" + bytes.length);
        writeSmallBinaryFile(shifted);
    }
    
    public ReadBinaryFile(String outputFile, int key) throws IOException {
        this.outputFile = outputFile;
        this.key = key;
        bytes = readSmallBinaryFile(this.outputFile);
        byte[] shifted = decrypt();
        log("Small - size of file read in:" + bytes.length);
        writeSmallBinaryFile(shifted);
    }
    
    byte[] readSmallBinaryFile(String aFileName) throws IOException {
            Path path = Paths.get(aFileName);
            return Files.readAllBytes(path);
        }

    public void writeSmallBinaryFile(byte[] bytes) throws IOException {
        Path path = Paths.get(outputFile);
        Files.write(path, bytes); //creates, overwrites
    }

    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }
    
    public byte[] encrypt() {
        BigInteger byteArray = new BigInteger(bytes);
        BigInteger shifted = byteArray.shiftRight(key);
        byte[] shift = shifted.toByteArray();
        return shift;
    }
    
    public byte[] decrypt() {
        BigInteger byteArray = new BigInteger(bytes);
        BigInteger shifted = byteArray.shiftLeft(key);
        byte[] shift = shifted.toByteArray();
        return shift;
    }
    
}
