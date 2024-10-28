package org.clases.ejercicio02;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ImprimirTodasEtiquetas {

    public void tecnicaDom(){
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance() ;
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Lee y analiza el documento xml, devolviendo un objeto d este
            Document doc = dBuilder.parse( new File("libros.xml") ) ;
            doc.getDocumentElement().normalize() ;

            JOptionPane.showMessageDialog(null, "El nombre del elemento raiz del archivo libros.xml es : "
                    + doc.getDocumentElement().getNodeName());

            //Obtenemos la lista de nodos
            NodeList nodos = doc.getElementsByTagName("libro");

            //Imprimimos el nombre de cada uno de los nodos
            for (int i = 0; i < nodos.getLength(); i++) {
                Node elemento = nodos.item(i);
                //Nombre del nodo
                String nodo= elemento.getNodeName();
                if (elemento.getNodeType() == Node.ELEMENT_NODE) {
                    //Atributo Año
                    Node anio = elemento.getAttributes().getNamedItem("año");
                    JOptionPane.showMessageDialog(null, nodo + " " + (i + 1) + " - " + anio);
                    NodeList detallesLibro = elemento.getChildNodes();
                    JOptionPane.showMessageDialog(null, "Nodos hijos: ");
                    for (int j = 0; j < detallesLibro.getLength(); j++) {
                        Node detalle = detallesLibro.item(j);
                        if (detalle.getNodeType() == Node.ELEMENT_NODE) {
                            String nombreNodoHijo = detalle.getNodeName();
                            switch (nombreNodoHijo) {
                                case "titulo", "editorial" -> {
                                    String valorElemento = detalle.getTextContent().trim();
                                    JOptionPane.showMessageDialog(null,  nombreNodoHijo+ ": " + valorElemento);
                                }
                                case "precio" -> {
                                    String valorElemento = detalle.getTextContent().trim();
                                    JOptionPane.showMessageDialog(null,  nombreNodoHijo+ ": " + valorElemento+"€");
                                }
                                case "autor" -> {
                                    NodeList detallesAutor = detalle.getChildNodes();
                                    String nombre = "", apellido = "";
                                    for (int k = 0; k < detallesAutor.getLength(); k++) {
                                        Node detalleAutor = detallesAutor.item(k);
                                        if (detalleAutor.getNodeType() == Node.ELEMENT_NODE) {
                                            Node elementoAutor = detalleAutor;
                                            switch (elementoAutor.getNodeName()) {
                                                case "apellido" -> apellido = elementoAutor.getTextContent().trim();
                                                case "nombre" -> nombre = elementoAutor.getTextContent().trim();
                                            }
                                        }

                                    }
                                    JOptionPane.showMessageDialog(null, "Autor\n"+"Nombre: " + nombre + "\n Apellido: " + apellido);

                                }
                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException  e) {
            throw new RuntimeException(e);
        }
    }
    public void tecnicaSAX(Element elementos) {

    }
}