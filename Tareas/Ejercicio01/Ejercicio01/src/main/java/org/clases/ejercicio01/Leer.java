package org.clases.ejercicio01;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leer {

    public void leerArchivo(String archivo){

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            DOMImplementation implementation = builder.getDOMImplementation();

            Document document = implementation.createDocument(null, "empleados", null);


            RandomAccessFile file = new RandomAccessFile(archivo, "rw");

            while (file.getFilePointer() < file.length()) {
                Element empleadoElement = document.createElement("empleado");

                int codigo = file.readInt();

                //Atributo codigo
                Element codigoElement = document.createElement("codigo");
                Text codigoText = document.createTextNode(codigo + "");
                codigoElement.appendChild(codigoText);
                empleadoElement.appendChild(codigoElement);

                StringBuilder nombre = new StringBuilder();
                for (int i = 0; i < 20; i++) {
                    char c = file.readChar();
                    if (c != '\u0000') {  // Filtramos los caracteres nulos
                        nombre.append(c);
                    }
                }

                //Atributo nombre
                Element nombreElement = document.createElement("nombre");
                Text nombreText = document.createTextNode(nombre.toString().trim());
                nombreElement.appendChild(nombreText);
                empleadoElement.appendChild(nombreElement);


                StringBuilder direccion = new StringBuilder();
                for (int i = 0; i < 20; i++) {
                    char c = file.readChar();
                    if (c != '\u0000') {  // Filtramos los caracteres nulos
                        direccion.append(c);
                    }
                }

                //Atributo direccion
                Element direccionElement = document.createElement("direccion");
                Text direccionText = document.createTextNode(direccion.toString().trim());
                direccionElement.appendChild(direccionText);
                empleadoElement.appendChild(direccionElement);

                //Atributo salario
                float salario = file.readFloat();
                Element salarioElement = document.createElement("salario");
                Text salarioText = document.createTextNode(salario + "");
                salarioElement.appendChild(salarioText);
                empleadoElement.appendChild(salarioElement);

                //Atributo comision
                float comision = file.readFloat();
                Element comisionElement = document.createElement("comision");
                Text comisionText = document.createTextNode(comision + "");
                comisionElement.appendChild(comisionText);
                empleadoElement.appendChild(comisionElement);

                document.getDocumentElement().appendChild(empleadoElement);

            }
                Source source = new DOMSource(document);
                Result result = new StreamResult(new File("empleados.xml"));

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                transformer.transform(source, result);

        } catch (ParserConfigurationException | IOException  | TransformerException e ) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
