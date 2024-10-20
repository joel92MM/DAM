package org.ejercicios.principal;

import org.ejercicios.Ejercicio01;
import org.ejercicios.Ejercicio02;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al programa de ejercicios de Java");


        boolean salir = false;

        while (!salir) {
            JTextArea textArea = new JTextArea(
                    "Seleccione una opción del menú:\n"
                    + "1. Crea un programa en Java que cree un archivo llamado miArchivo.txt en el directorio C:/prueba y verifique si ya existe antes de crearlo.\n"
                    + "2. Implementa un programa que elimine un archivo llamado archivo_a_borrar.txt y verifique si la eliminación fue exitosa.\n"
                    + "3. Crea un directorio llamado nuevaCarpeta dentro del directorio C:/prueba y muestra un mensaje en la consola indicando si fue creado correctamente.\n"
                    + "4. Escribe un programa que permita al usuario escribir una cadena en un archivo textoSalida.txt utilizando FileWriter.\n"
                    + "5. Implementa un programa que lea el contenido del archivo textoEntrada.txt línea por línea usando BufferedReader y lo muestre en la consola.\n"
                    + "6. Desarrolla un programa que copie el contenido de un archivo entrada.txt a salida.txt usando FileReader y FileWriter.\n"
                    + "7. Crea un programa que determine si una ruta proporcionada es absoluta o relativa utilizando el método isAbsolute() de la clase File.\n"
                    + "8. Escribe un programa que liste todos los archivos y subdirectorios dentro de C:/prueba y los muestre en consola.\n"
                    + "9. Desarrolla un programa que renombre un archivo llamado archivo.txt a archivoRenombrado.txt en el mismo directorio.\n"
                    + "10. Crea un programa que lea el contenido de un archivo de texto de manera secuencial y lo imprima en la consola.\n"
                    + "11. Usa RandomAccessFile para escribir una cadena en una posición específica de un archivo llamado datos.txt.\n"
                    + "12. Implementa un programa que lea desde una posición específica en un archivo utilizando RandomAccessFile y muestre el resultado en consola.\n"
                    + "13. Escribe un programa que liste solo los archivos con extensión .txt en el directorio C:/prueba, utilizando un filtro con FilenameFilter.\n"
                    + "14. Crea un programa que liste solo los directorios dentro de C:/prueba utilizando el método listFiles() y verificando si es un directorio.\n"
                    + "15. Implementa un programa que liste todos los archivos en un directorio y los ordene alfabéticamente antes de mostrarlos.\n"
                    + "16. Escribir bytes en archivo binario: Desarrolla un programa que escriba un array de bytes en un archivo binario llamado datos.bin usando FileOutputStream.\n"
                    + "17. Leer archivo binario: Crea un programa que lea el contenido de un archivo datos.bin utilizando FileInputStream y muestre los datos en consola.\n"
                    + "18. Modificar archivo binario con RandomAccessFile: Usa RandomAccessFile para modificar un byte en una posición específica dentro de datos.bin.\n"
                    + "19. Copiar archivo con Files.copy(): Implementa un programa que copie un archivo desde origen.txt a destino.txt utilizando el método Files.copy().\n"
                    + "20. Mover archivo con Files.move(): Crea un programa que mueva un archivo mover.txt de un directorio a otro utilizando Files.move().\n"
                    + "21. Eliminar archivo con Files.delete(): Desarrolla un programa que elimine un archivo llamado borrar.txt usando el método Files.delete() y maneje posibles excepciones.\n"
                    + "22. Escritura en un archivo binario: Desarrolla un programa en Java que escriba datos numéricos (como enteros y floats) en un archivo binario llamado datos.bin usando DataOutputStream.\n"
                    + "23. Lectura de un archivo binario: Crea un programa que lea el archivo datos.bin utilizando DataInputStream y muestra los datos leídos en consola.\n"
                    + "24. Copiar un archivo binario: Implementa un programa que copie el contenido de un archivo binario llamado original.bin a un archivo nuevo llamado copia.bin utilizando FileInputStream y FileOutputStream.\n"
                    + "25. Leer archivo línea por línea: Crea un programa que lea un archivo de texto lectura.txt línea por línea utilizando BufferedReader y muestra el contenido en consola.\n"
                    + "26. Escribir y agregar texto a un archivo: Desarrolla un programa que escriba texto en un archivo escribir.txt y luego agregue más contenido al final del archivo usando FileWriter en modo append.\n"
                    + "27. Filtrar y listar archivos por tamaño: Escribe un programa que filtre y liste solo los archivos de más de 1MB en un directorio específico usando la clase File.\n"
                    + "28. Leer archivo de acceso aleatorio: Utiliza RandomAccessFile para leer y mostrar el contenido de un archivo datos.txt desde una posición específica.\n"
                    + "29. Modificar un archivo usando RandomAccessFile: Crea un programa que modifique el contenido de un archivo de texto en una posición específica utilizando RandomAccessFile.\n"
                    + "30. Copiar contenido de un archivo secuencialmente: Desarrolla un programa que copie un archivo de texto origen.txt a destino.txt línea por línea utilizando BufferedReader y BufferedWriter.\n"
                    + "31. Listar archivos con extensión específica: Escribe un programa que liste solo los archivos .java en un directorio usando un filtro con FilenameFilter.\n"
                    + "32. Listar archivos ordenados por tamaño: Desarrolla un programa que liste los archivos en un directorio ordenados por su tamaño, de mayor a menor.\n"
                    + "33. Listar solo archivos ocultos: Crea un programa que muestre únicamente los archivos ocultos de un directorio usando el método isHidden().\n"
                    + "34. Copiar archivo con Files.copy(): Implementa un programa que copie un archivo documento.txt de un directorio a otro utilizando el método Files.copy() de java.nio.file.\n"
                    + "35. Mover un archivo con Files.move(): Crea un programa que mueva un archivo movible.txt de un directorio a otro utilizando el método Files.move() de java.nio.file.\n"
                    + "36. Eliminar un archivo con Files.delete(): Desarrolla un programa que elimine un archivo llamado eliminar.txt de un directorio utilizando el método Files.delete().\n"
                    + "37. Lectura de un archivo XML usando DOM: Crea un programa en Java que lea un archivo XML llamado libros.xml, cargue su contenido en un árbol DOM, y muestre todos los títulos de libros que contiene.\n"
                    + "38. Modificación de un archivo XML usando DOM: Implementa un programa que modifique el contenido de un archivo XML, cambiando el precio de un libro específico dentro del archivo libros.xml.\n"
                    + "39. Validación de un archivo XML: Desarrolla un programa que verifique si un archivo libros.xml cumple con un esquema XSD proporcionado, utilizando DocumentBuilderFactory y un validador.\n"
                    + "40. Generar un archivo XML desde Java: Escribe un programa que genere un archivo XML llamado clientes.xml, que contenga una lista de clientes con nombre, dirección y teléfono, utilizando Transformer y DocumentBuilder.\n"
                    + "41. Conversión de un archivo XML a otro formato: Crea un programa en Java que convierta un archivo XML llamado productos.xml a formato HTML utilizando XSLT.\n"
                    + "42. Lectura y escritura de atributos en XML: Implementa un programa que lea los atributos de un archivo XML, como el idioma (lang) de un elemento <libro>, y luego modifique estos atributos y guarde los cambios en el archivo.\n"
                    + "43. Acceder a nodos específicos en un archivo XML: Escribe un programa que acceda a los nodos de un archivo XML libros.xml y muestre todos los valores de los nodos <autor>.\n"
                    + "44. Modificar nodos en un XML: Desarrolla un programa que cambie el contenido de un nodo <precio> en un archivo XML y guarde los cambios en un archivo libros_modificado.xml.\n"
                    + "45. Eliminar nodos de un XML: Implementa un programa que elimine un nodo <libro> del archivo XML libros.xml si el precio del libro es superior a un valor determinado.\n"
                    + "46. Procesar un XML utilizando StAX: Crea un programa que procese un archivo XML llamado empleados.xml utilizando StAX, mostrando el nombre y el cargo de cada empleado.\n"
                    + "47. Escribir en un XML utilizando StAX: Desarrolla un programa que escriba un archivo XML empleados_stax.xml con una lista de empleados utilizando la API StAX.\n"
                    + "48. Filtrar elementos en un XML con StAX: Implementa un programa que filtre y muestre solo los libros con precio superior a 30 en un archivo libros.xml utilizando StAX.\n"
                    + "49. Manejo de eventos XML con StAX: Crea un programa que procese un archivo XML llamado eventos.xml utilizando StAX y capture los eventos de inicio y fin de cada elemento, mostrando su nombre.\n"
                    + "50. Capturar atributos en eventos XML: Desarrolla un programa que capture y muestre los atributos de elementos específicos en un archivo XML productos.xml utilizando StAX.\n"
                    + "51. Modificar XML utilizando StAX y eventos: Escribe un programa que modifique los atributos de elementos en un archivo XML utilizando StAX y guarde los cambios en un archivo nuevo.\n"
                    + "52. Crear un archivo temporal: Implementa un programa que cree un archivo temporal en el sistema y lo elimine después de un cierto tiempo.\n"
                    + "53. Eliminar un archivo temporal: Crea un programa que elimine un archivo temporal en el sistema utilizando la clase File.\n"
                    + "54. Comprobar si un archivo temporal existe: Desarrolla un programa que verifique la existencia de un archivo temporal en el sistema.\n"
                    + "55. Crear y listar archivos de un directorio: Escribe un programa que cree un directorio y luego liste todos los archivos contenidos en él.\n"
                    + "56. Renombrar un archivo: Implementa un programa que cambie el nombre de un archivo en el sistema utilizando la clase File.\n"
                    + "57. Eliminar un directorio completo: Crea un programa que elimine un directorio y todos sus archivos contenidos.\n"
                    + "58. Crear múltiples directorios: Desarrolla un programa que cree una estructura de directorios anidada en el sistema.\n"
                    + "59. Verificar permisos de un archivo: Implementa un programa que verifique los permisos de lectura, escritura y ejecución de un archivo específico.\n"
                    + "60. Obtener propiedades de un archivo: Escribe un programa que obtenga y muestre propiedades de un archivo, como tamaño, fecha de modificación y ruta.\n"
                    + "61. Obtener ruta absoluta de un archivo: Crea un programa que obtenga la ruta absoluta de un archivo dado.\n"
                    + "62. Comparar rutas de archivos: Desarrolla un programa que compare dos rutas de archivos y determine si apuntan al mismo archivo.\n"
                    + "63. Comprobar si una ruta es un archivo o un directorio: Implementa un programa que determine si una ruta es un archivo o un directorio.\n"
                    + "64. Filtrar archivos por extensión: Escribe un programa que filtre y liste solo los archivos con una extensión específica en un directorio.\n"
                    + "65. Filtrar archivos ocultos: Crea un programa que filtre y liste solo los archivos ocultos de un directorio.\n"
                    + "66. Crear un filtro personalizado: Implementa un programa que permita filtrar archivos en un directorio según criterios personalizados (por ejemplo, tamaño mínimo o nombre).\n"
                    + "67. Serialización de un objeto: Desarrolla un programa que serialice un objeto Java y lo guarde en un archivo binario.\n"
                    + "68. Deserialización de un objeto: Crea un programa que deserialice un objeto desde un archivo binario y lo muestre en consola.\n"
                    + "69. Modificar un objeto serializado: Escribe un programa que deserialice un objeto, modifique sus propiedades y lo vuelva a serializar.\n"
                    + "70. Escribir en un archivo binario: Implementa un programa que escriba datos en un archivo binario utilizando DataOutputStream.\n"
                    + "71. Leer desde un archivo binario: Desarrolla un programa que lea datos de un archivo binario utilizando DataInputStream.\n"
                            + "0. Salir");


            // Hacer el JTextArea no editable
            textArea.setEditable(false);

            // Crear un JScrollPane y agregar el JTextArea a él
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));

            // Mostrar el JScrollPane en un JOptionPane
            String opcion = JOptionPane.showInputDialog(
                    null, scrollPane, "Menú de Opciones", JOptionPane.PLAIN_MESSAGE
            );

            // Comprobar si el usuario presionó Cancelar o cerró la ventana
            if (opcion == null) {
                salir = true;
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }

            int opcionMenu;
            try {
                opcionMenu = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del 0 al 10.");
                continue;
            }

            switch (opcionMenu) {
                case 1:
                    String nombreArchivo=JOptionPane.showInputDialog("Ingrese el nombre del archivo a crear");
                    Ejercicio01 ejercicio01=new Ejercicio01();
                    ejercicio01.crearArchivo(nombreArchivo);
                    break;
                case 2:
                    String nombreABorrar=JOptionPane.showInputDialog("Ingrese el nombre del archivo a borrar");
                    Ejercicio02 ejercicio02=new Ejercicio02();
                    ejercicio02.borrarArchivoExistente(nombreABorrar);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 0:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción del 0 al 10.");
            }
        }

    }
}