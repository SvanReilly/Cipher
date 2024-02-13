package cipherpackage;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
/**
*
*
*/
public class Main {
/**
* @param args the command line arguments
*/
public static void main(String[] args) {
int puerto = 5555;
try {
// Creo el servidor
new SSLServidor(puerto).start();
// Creo un cliente
new SSLCliente("localhost", puerto).start();
} catch (IOException | KeyManagementException | KeyStoreException
| NoSuchAlgorithmException | UnrecoverableKeyException
| CertificateException error) {
System.out.println("Error -> " + error.toString());
}
}
}

