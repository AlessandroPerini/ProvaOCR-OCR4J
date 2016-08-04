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
        
        
        Eye eye = new Eye() {
            @Override
            public float[] lookAt(BufferedImage image) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int getReceptorsCount() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public float getMaxReceptorValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public float getMinReceptorValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        ActivationFunction activationFunction = null;
        NeuralNetwork network = new NeuralNetworkImpl(activationFunction, 0);
        
        char[] alphabet = {'a','b','c','d','d','f'};
        
        /**
         * In demo/DemoApplet viene istanziato un OCR con il costruttore senza parametri.. new OCR();
         * Facendo così però durante l'esecuzione parte un'eccezione.
         * Ho utilizzato il costruttore di OCR con i parametri ma non so come implementare Eye.
         * Per NeuralNetwork invece c'è gia una implementazione NeuralNetworkImpl, ma non so come funziona.
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
