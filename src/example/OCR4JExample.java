/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import ee.ttu.ann.NeuralNetwork;
import ee.ttu.ann.NeuralNetworkImpl;
import ee.ttu.math.ActivationFunction;
import ee.ttu.ocr.Eye;
import ee.ttu.ocr.OCR;
import ee.ttu.ocr.RandomReceptorEye;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author aless
 */
public class OCR4JExample {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        
        Eye eye = new RandomReceptorEye(0);
        
        ActivationFunction activationFunction = null;
        NeuralNetwork network = new NeuralNetworkImpl(activationFunction, 0);
        
        char[] alphabet = {'a','b','c','d','d','f'};
        
        /**
         * In demo/DemoApplet viene istanziato un OCR con il costruttore senza parametri.. new OCR();
         * Facendo così però durante l'esecuzione parte un'eccezione.
         * Ho utilizzato il costruttore di OCR con i parametri.
         * Per NeuralNetwork e Eye uso le due implementazioni che ho trovato,
         * NeuralNetworkImpl e RandomReceptorEye, ma non so come funzionano.
         * Così il file viene eseguito ma non da risultati.
         * 
        */
        OCR ocr = new OCR(network, eye, alphabet);
        
        File file = new File("src/file/image1.jpg");
        BufferedImage image = ImageIO.read(file);
        String text = ocr.recognise(image);
        
        System.out.println(text);
    }
    
}
