package org.clases.ejercicio01;


import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlGenerator {
    public void generateXml(String archivoALeer, String[] tiposDeAtributos,
                            String[] nombresAtributos,
                             String nombreElemento, String nombreDocumento) {



            try {
                // Inicializamos el documento XML
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                Document document = implementation.createDocument(null, nombreDocumento, null);

                // Lectura del archivo de acceso aleatorio
                RandomAccessFile file = new RandomAccessFile(archivoALeer, "rw");

                // Bucle de lectura hasta el final del archivo
                while (file.getFilePointer() < file.length()) {
                    Element elementoRegistro = document.createElement(nombreElemento);

                    for (int i = 0; i < tiposDeAtributos.length; i++) {
                        String tipo = tiposDeAtributos[i];
                        String nombre = nombresAtributos[i];

                        Element elemento = document.createElement(nombre);

                        switch (tipo) {
                            case "int":
                                int valorInt = file.readInt();
                                Text textoInt = document.createTextNode(String.valueOf(valorInt));
                                elemento.appendChild(textoInt);
                                break;

                            case "float":
                                float valorFloat = file.readFloat();
                                Text textoFloat = document.createTextNode(String.valueOf(valorFloat));
                                elemento.appendChild(textoFloat);
                                break;

                            case "string":
                                StringBuilder cadena = new StringBuilder();
                                for (int j = 0; j < 20; j++) {  // Suponemos longitud fija de 20 caracteres
                                    char c = file.readChar();
                                    if (c != '\u0000') {
                                        cadena.append(c);
                                    }
                                }
                                Text textoString = document.createTextNode(cadena.toString().trim());
                                elemento.appendChild(textoString);
                                break;

                            default:
                                System.out.println("Tipo de dato no reconocido: " + tipo);
                                break;
                        }

                        elementoRegistro.appendChild(elemento);
                    }

                    document.getDocumentElement().appendChild(elementoRegistro);
                }

                // Guardar el documento XML en archivo
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                Source source = new DOMSource(document);
                Result result = new StreamResult(new File(nombreDocumento+".xml"));

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                transformer.transform(source, result);

                // Cerrar archivo
                file.close();

            } catch (ParserConfigurationException | IOException | TransformerException e) {
                Logger.getLogger(XmlGenerator.class.getName()).log(Level.SEVERE, null, e);
            }
        }
}
